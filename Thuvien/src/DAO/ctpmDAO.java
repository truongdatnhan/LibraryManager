package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import DTO.ctpmDTO;

public class ctpmDAO {
	MyConnectUnit conn = null;
	ResultSet rs = null;
	ArrayList<ctpmDTO> dsctm = null;
	HashMap<String, ArrayList<ctpmDTO>> map = null;

	public ctpmDAO() {
		conn = new MyConnectUnit("localhost", "root", "", "thuvien","ctpmDAO");
	}

	public ArrayList<ctpmDTO> docCTPM() throws Exception {
		dsctm = new ArrayList<ctpmDTO>();
		rs = conn.Select("ctphieumuon");
		while (rs.next()) {
			ctpmDTO ctpm = new ctpmDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(6),rs.getInt(5));
			dsctm.add(ctpm);
		}
		conn.Close();
		return dsctm;
	}

	public void Insert(ctpmDTO ctpm) throws Exception {

		if (ctpm.getTinhtrang().equals("Đã trả")) {
			JOptionPane.showMessageDialog(null, "Thêm sai cách");
			conn.Close();
			return;
		}

		HashMap<String, Object> insertValue = new HashMap<String, Object>();
		insertValue.put("mapm", ctpm.getMapm());
		insertValue.put("masach", ctpm.getMasach());
		insertValue.put("soluong", ctpm.getSoluong());
		insertValue.put("tinhtrang", ctpm.getTinhtrang());
		insertValue.put("tienthechan", ctpm.getTienthechan());
		insertValue.put("ngaythuctra", ctpm.getNgaythuctra());
		// boolean kt = conn.Insert("ctphieumuon", insertValue);

		HashMap<String, Object> phieumuonValue = new HashMap<>();
		phieumuonValue.put("tongtienmuon", "tongtienmuon + " + ctpm.getTienthechan());

		HashMap<String, Object> sachValue = new HashMap<String, Object>();
		sachValue.put("soluong", "soluong - " + ctpm.getSoluong());
		boolean check = conn.UpdateNoComma("sach", sachValue,"masach = '" + ctpm.getMasach() + "'" + " AND " + "(soluong - " + ctpm.getSoluong() + ") >= '0'");

		if (check == true) {
			JOptionPane.showMessageDialog(null, "Trừ sách thành công");
			boolean kt = conn.Insert("ctphieumuon", insertValue);
			if (kt == true) {
				JOptionPane.showMessageDialog(null, "Thêm thành công");
				boolean moneyUpdate = conn.UpdateNoComma("phieumuon", phieumuonValue, "mapm= '" + ctpm.getMapm() + "'");
				if (moneyUpdate == true) {
					JOptionPane.showMessageDialog(null, "Thêm tiền thành công");
				} else {
					JOptionPane.showMessageDialog(null, "Thêm tiền thất bại");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Thêm thất bại");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Trừ sách thất bại");
		}

		conn.Close();
	}

	public void Update(ctpmDTO ctpm) throws Exception {
		/*
		 * HashMap<String, Object> updateValue = new HashMap<String, Object>();
		 * //updateValue.put("mapm", ctpm.getMapm()); //updateValue.put("masach",
		 * ctpm.getMasach()); updateValue.put("soluong", ctpm.getSoluong());
		 * updateValue.put("tinhtrang", ctpm.getTinhtrang());
		 * updateValue.put("ngaythuctra", ctpm.getNgaythuctra()); boolean kt =
		 * conn.Update("ctphieumuon", updateValue, "mapm = '" + ctpm.getMapm() + "'" +
		 * " AND " + "masach = '" + ctpm.getMasach() + "'");
		 */

		for (ctpmDTO phieu : filteredList(ctpm.getMapm())) {
			// System.out.println(phieu.toString());
			if (phieu.getMasach().equalsIgnoreCase(ctpm.getMasach())) {
				int priceChange = Math.abs(phieu.getTienthechan() - ctpm.getTienthechan());
				// System.out.println(priceChange);

				if (ctpm.getSoluong() > phieu.getSoluong()) {
					if (ctpm.getTinhtrang().equals("Đã trả")) {
						JOptionPane.showMessageDialog(null, "Thêm sai cách");
						conn.Close();
						return;
					}
					System.out.println("SL CTPM > SL cũ");
					HashMap<String, Object> updateValue = new HashMap<String, Object>();
					updateValue.put("soluong", ctpm.getSoluong());
					updateValue.put("tinhtrang", ctpm.getTinhtrang());
					updateValue.put("ngaythuctra", ctpm.getNgaythuctra());

					HashMap<String, Object> sachValue = new HashMap<String, Object>();
					sachValue.put("soluong", "soluong - " + (ctpm.getSoluong() - phieu.getSoluong()));
					boolean check = conn.UpdateNoComma("sach", sachValue, "masach = '" + ctpm.getMasach() + "'"
							+ " AND " + "(soluong - " + (ctpm.getSoluong() - phieu.getSoluong()) + ") >= '0'");

					if (check == true) {
						JOptionPane.showMessageDialog(null, "Sửa(trừ) số lượng sách công");
						boolean kt = conn.Update("ctphieumuon", updateValue,
								"mapm = '" + ctpm.getMapm() + "'" + " AND " + "masach = '" + ctpm.getMasach() + "'");
						if (kt == true) {
							if (phieu.getTienthechan() < ctpm.getTienthechan()) {
								updateValue.put("tienthechan", ctpm.getTienthechan());
								congTienPhieuMuon(ctpm, priceChange);
							}
							if (phieu.getTienthechan() > ctpm.getTienthechan()) {
								updateValue.put("tienthechan", ctpm.getTienthechan());
								truTienPhieuMuon(ctpm, priceChange);
							}
							JOptionPane.showMessageDialog(null, "Sửa thành công");
						} else {
							JOptionPane.showMessageDialog(null, "Sửa thất bại");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Sửa số lượng sách thất bại");
					}
					break;
				}
				if (ctpm.getSoluong() < phieu.getSoluong()) {
					if (ctpm.getTinhtrang().equals("Đã trả")) {
						JOptionPane.showMessageDialog(null, "Thêm sai cách");
						conn.Close();
						return;
					}
					System.out.println("SL CTPM < SL cũ");
					HashMap<String, Object> updateValue = new HashMap<String, Object>();
					updateValue.put("soluong", ctpm.getSoluong());
					updateValue.put("tinhtrang", ctpm.getTinhtrang());
					updateValue.put("ngaythuctra", ctpm.getNgaythuctra());

					HashMap<String, Object> sachValue = new HashMap<String, Object>();
					sachValue.put("soluong", "soluong + " + (phieu.getSoluong() - ctpm.getSoluong()));
					boolean check = conn.UpdateNoComma("sach", sachValue, "masach = '" + ctpm.getMasach() + "'");

					if (check == true) {
						JOptionPane.showMessageDialog(null, "Sửa(thêm) số lượng sách công");
						if (phieu.getTienthechan() < ctpm.getTienthechan()) {
							updateValue.put("tienthechan", ctpm.getTienthechan());
							congTienPhieuMuon(ctpm, priceChange);
						}
						if (phieu.getTienthechan() > ctpm.getTienthechan()) {
							updateValue.put("tienthechan", ctpm.getTienthechan());
							truTienPhieuMuon(ctpm, priceChange);
						}
						boolean kt = conn.Update("ctphieumuon", updateValue,
								"mapm = '" + ctpm.getMapm() + "'" + " AND " + "masach = '" + ctpm.getMasach() + "'");
						if (kt == true) {
							JOptionPane.showMessageDialog(null, "Sửa thành công");
						} else {
							JOptionPane.showMessageDialog(null, "Sửa thất bại");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Sửa số lượng sách thất bại");
					}

					break;
				}
				if (ctpm.getSoluong() == phieu.getSoluong()) {
					if (ctpm.getTinhtrang().equals("Đã trả")) {
						if (phieu.getTienthechan() != ctpm.getTienthechan()) {
							JOptionPane.showMessageDialog(null, "Thêm sai cách");
							conn.Close();
							return;
						} else {
							HashMap<String, Object> updateValue = new HashMap<String, Object>();
							updateValue.put("soluong", ctpm.getSoluong());
							updateValue.put("tinhtrang", ctpm.getTinhtrang());
							updateValue.put("ngaythuctra", ctpm.getNgaythuctra());

							HashMap<String, Object> sachValue = new HashMap<String, Object>();
							sachValue.put("soluong", "soluong + " + ctpm.getSoluong() );
							boolean check = conn.UpdateNoComma("sach", sachValue,
									"masach = '" + ctpm.getMasach() + "'");

							if (check == true) {
								JOptionPane.showMessageDialog(null, "Thêm sách (Trả) thành công");
								boolean kt = conn.Update("ctphieumuon", updateValue, "mapm = '" + ctpm.getMapm() + "'"
										+ " AND " + "masach = '" + ctpm.getMasach() + "'");
								if (kt == true) {
									JOptionPane.showMessageDialog(null, "Sửa thành công");
								} else {
									JOptionPane.showMessageDialog(null, "Sửa thất bại");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Thêm sách (Trả) thất bại");
							}

							break;
						}
					} else {
						HashMap<String, Object> updateValue = new HashMap<String, Object>();
						updateValue.put("soluong", ctpm.getSoluong());
						updateValue.put("tinhtrang", ctpm.getTinhtrang());
						updateValue.put("ngaythuctra", ctpm.getNgaythuctra());

						if (phieu.getTienthechan() < ctpm.getTienthechan()) {
							updateValue.put("tienthechan", ctpm.getTienthechan());
							congTienPhieuMuon(ctpm, priceChange);
						}
						if (phieu.getTienthechan() > ctpm.getTienthechan()) {
							updateValue.put("tienthechan", ctpm.getTienthechan());
							truTienPhieuMuon(ctpm, priceChange);
						}
						boolean kt = conn.Update("ctphieumuon", updateValue,
								"mapm = '" + ctpm.getMapm() + "'" + " AND " + "masach = '" + ctpm.getMasach() + "'");

						if (kt == true) {
							JOptionPane.showMessageDialog(null, "Sửa thành công");
						} else {
							JOptionPane.showMessageDialog(null, "Sửa thất bại");
						}
						break;
					}
				}
			}
		}
		conn.Close();
	}

	public void Delete(ctpmDTO ctpm) throws Exception {
		StringBuilder query = new StringBuilder();
		query.append("mapm = '").append(ctpm.getMapm()).append("'").append(" AND ").append("masach = '")
				.append(ctpm.getMasach()).append("'");
		// System.out.println(query.toString());

		HashMap<String, Object> phieumuonValue = new HashMap<>();
		phieumuonValue.put("tongtienmuon", "tongtienmuon - " + ctpm.getTienthechan());

		HashMap<String, Object> sachValue = new HashMap<String, Object>();
		sachValue.put("soluong", "soluong + " + ctpm.getSoluong());
		boolean check = conn.UpdateNoComma("sach", sachValue, "masach = '" + ctpm.getMasach() + "'");

		if (check == true) {
			JOptionPane.showMessageDialog(null, "Thêm số lượng sách(Xoá) thành công");
			boolean kt = conn.DeleteReal("ctphieumuon", query.toString());
			if (kt == true) {
				JOptionPane.showMessageDialog(null, "Xoá thành công");
				boolean moneyUpdate = conn.UpdateNoComma("phieumuon", phieumuonValue, "mapm= '" + ctpm.getMapm() + "'");
				if (moneyUpdate == true) {
					JOptionPane.showMessageDialog(null, "Trừ tiền thành công");
				} else {
					JOptionPane.showMessageDialog(null, "Trừ tiền thất bại");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Xoá thất bại");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Thêm số lượng sách(Xoá) thất bại");
		}
		conn.Close();
	}

	public ArrayList<ctpmDTO> filteredList(String ID) throws Exception {
		dsctm = docCTPM();
		ArrayList<ctpmDTO> edited = new ArrayList<ctpmDTO>();
		for (ctpmDTO ctp : dsctm) {
			if (ctp.getMapm().compareTo(ID) == 0) {
				edited.add(ctp);
			}
		}
		return edited;
	}

	public void truTienPhieuMuon(ctpmDTO ctpm, int money) throws Exception {
		HashMap<String, Object> phieumuonValue = new HashMap<>();
		phieumuonValue.put("tongtienmuon", "tongtienmuon - " + money);
		boolean moneyUpdate = conn.UpdateNoComma("phieumuon", phieumuonValue,
				"mapm= '" + ctpm.getMapm() + "'" + " AND " + "(tongtienmuon - " + money + ") >=0");
		if (moneyUpdate == true) {
			JOptionPane.showMessageDialog(null, "Trừ tiền thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Trừ tiền thất bại");
		}
	}

	public void congTienPhieuMuon(ctpmDTO ctpm, int money) throws Exception {
		HashMap<String, Object> phieumuonValue = new HashMap<>();
		phieumuonValue.put("tongtienmuon", "tongtienmuon + " + money);
		boolean moneyUpdate = conn.UpdateNoComma("phieumuon", phieumuonValue, "mapm= '" + ctpm.getMapm() + "'");
		if (moneyUpdate == true) {
			JOptionPane.showMessageDialog(null, "Trừ tiền thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Trừ tiền thất bại");
		}
	}

	// Sẽ optimal bằng hashmap sau nếu có thời gian
	public HashMap<String, ArrayList<ctpmDTO>> getMap() throws Exception {
		dsctm = docCTPM();

		for (ctpmDTO c : dsctm) {
			if (map.containsKey(c.getMapm())) {
				map.get(c.getMapm()).add(c);
			} else {
				map.put(c.getMapm(), new ArrayList<ctpmDTO>());
				map.get(c.getMapm()).add(c);
			}
		}

		return map;
	}

}
