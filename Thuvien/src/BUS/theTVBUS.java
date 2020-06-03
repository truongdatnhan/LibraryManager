package BUS;

import java.util.ArrayList;

import DAO.theTVDAO;
import DTO.theTVDTO;

public class theTVBUS {
	public static ArrayList<theTVDTO> dsttv;
	public static ArrayList<theTVDTO> newTTV;

	theTVDAO data = new theTVDAO();

	public ArrayList<theTVDTO> getTTVList() throws Exception {
		if (dsttv == null) {
			dsttv = new ArrayList<theTVDTO>();
		}
		dsttv = data.filteredList();
		return dsttv;
	}
	
	public ArrayList<theTVDTO> getNewTTVList() throws Exception{
		if(newTTV == null) {
			newTTV = new ArrayList<theTVDTO>();
		}
		newTTV = data.newCardList();
		return newTTV;
	}

	public void Insert(theTVDTO the) throws Exception {
		data.Insert(the);
		dsttv.add(the);
		// thêm thẻ thư viện này vào một arraylist khác dùng để thực hiện công việc thống kê
	//	newTTV.add(the);
	}
	
	public void Delete(theTVDTO the) throws Exception {
		data.Delete(the);
		dsttv.remove(the);
	}

	public void Update(theTVDTO the) throws Exception {
		data.Update(the);
		int k = 0;
		for(int i = 0;i<dsttv.size();i++) {
			if(dsttv.get(i).getMathe().equals(the.getMathe())) {
				k = i;
			}
		}
		dsttv.set(k, the);
	}
}
