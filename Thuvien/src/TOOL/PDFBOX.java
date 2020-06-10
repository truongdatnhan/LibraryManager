/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TOOL;

import DTO.sachDTO;
import BUS.sachBUS;
import java.awt.Font;
import java.awt.Color;
import java.awt.List;
import org.apache.pdfbox.pdmodel.*;
import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.fontbox.*;
import sun.font.Type1Font;


public class PDFBOX {
    PDDocument doc ;
    PDPage page;
    File font2=new File("C:\\Users\\gia\\Desktop\\Java\\thuvien java\\214-Font UVN\\UVNBanTay.ttf");
    PDFont font;
    public PDFBOX() {
        
        try{
            doc = new PDDocument();
            page=new PDPage();
            
            doc.addPage(page);
            //tạo font
             font=PDType0Font.load(doc, font2);
            //thêm nội dung
            sach();
            doc.save("hello.pdf");
            doc.close();
        } catch (Exception ex){
            System.out.println(ex);
        }
    }
    public void sach() throws IOException
    {
        PDPageContentStream content = new PDPageContentStream(doc, page);
                final float maxx=600;
                float startX=50;
                float startY=600;
                
                //vẼ hàng ngang từ phần tử
                startY=600-40;
                float temp=30;
                sachBUS bus=new sachBUS();
                bus.getSachList();
                for(int i=0;i<sachBUS.dss.size();i++)
                {
                    content.drawLine(startX, startY-temp,550 , startY-temp);
                    temp+=30;
                }
                temp+=12;
                startY=600;
                //vẽ khung
                    //ngang
                content.drawLine(startX, startY+(float)0.5,550,600+(float)0.5);
                content.drawLine(startX, startY+(float)1,550,600+(float)1);
                content.drawLine(startX, startY,550,600);
                    //dọc trai
                content.drawLine(startX-(float)0.5, startY,startX-(float)0.5 , startY-temp);
                content.drawLine(startX-(float)1, startY, startX-(float)1, startY-temp);
                content.drawLine(startX, startY, 50, startY-temp);
                    //dọc phải
                content.drawLine(550, startY, 550, startY-temp);
                content.drawLine(550+(float)0.5, startY,550+(float)0.5 , startY-temp);
                content.drawLine(550+(float)1, startY,550+(float)1 , startY-temp);
                    //ngang dưới
                content.drawLine(startX, startY-40, 550, startY-40);
                content.drawLine(startX, startY-40+(float)0.5,550,startY-40+(float)0.5);
                content.drawLine(startX, startY-40+(float)1,550,startY-40+(float)1);
                
                
                //vẽ cột-đưa dữ liệu header
                float temp2=(float) 62.5;
                content.beginText();
                        float temp3=temp2-(float)62.5;
                        content.setFont(font, 12);
                        content.setNonStrokingColor(Color.BLACK);//set màu chữ
                        content.moveTextPositionByAmount(startX+3, startY-(40/2));
                        content.showText("Mã sách");
                content.endText();
                
                content.beginText();
                        content.setFont(font, 12);
                        content.setNonStrokingColor(Color.BLACK);//set màu chữ
                        content.moveTextPositionByAmount(startX+53, startY-(40/2));
                        content.showText("Tên sách");
                    content.endText();
                String[] header={"Giá sách","Thể loại","Tác Giả","NXB","Lĩnh Vực","Số Lượng"};
                temp3=(float) 150;
                for(int i=0;i<=5;i++)
                {
                    content.beginText();
                        content.setFont(font, 12);
                        content.setNonStrokingColor(Color.BLACK);//set màu chữ
                        content.moveTextPositionByAmount(startX+3+temp3, startY-(40/2));
                        content.showText(header[i]);
                    content.endText();
                    content.drawLine(startX+3+temp3, startY-(40/2),startX+3+temp3 );
                    temp3=(float) (temp3+(float)62.5);
                }
                
                startY=600-40;
                //vẽ hàng-đưa dữ liệu vào
                for(int i=0;i<sachBUS.dss.size();i++)
                {
                    content.beginText();
                        sachDTO sach=(sachDTO)sachBUS.dss.get(i);
                        String[] data={sach.getMasach(),sach.getTensach(),String.valueOf(sach.getGiasach()),sach.getMatheloai(),sach.getMatg(),sach.getManxb(),sach.getMalinhvuc(),String.valueOf(sach.getSoluong())};
                        content.setFont(font, 12);
                        content.setNonStrokingColor(Color.BLACK);
//                        float temp3=(float)0;
//                        for(int j=0;j<=7;j++)
//                        {
//                            content.moveTextPositionByAmount(startX+3+temp3, startY-30*(i+1)+12);
//                            content.showText(data[j]);
//                            temp3+=(float)62.5;
//                        }
                            temp3=0;
                            content.moveTextPositionByAmount(startX+3+temp3,startY-30*(i+1)+12);
                            content.showText(data[0]);
                            content.moveTextPositionByAmount((float)40,0);
                            content.showText(data[1]);
                     content.endText();
                }
                
                //Chữ đầu file
                content.beginText(); 
                content.setNonStrokingColor(Color.BLACK);//set màu chữ
                content.moveTextPositionByAmount(230, 700);
                content.setFont(font,20);
                content.showText("Danh sách Sách");
                content.endText();
                //kết thúc
                content.close();
    }
    public static void main(String[] args) {
        PDFBOX a=new PDFBOX();
        
}
}
