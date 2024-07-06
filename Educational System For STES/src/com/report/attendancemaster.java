package com.report;

import com.connection.Dbconn;
import com.itextpdf.text.Image;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class attendancemaster {
	public static String reportfile = "D:\\ProjectCode\\report\\";
    public static String pid = null, pname = null, gender = null, emailid = null, age = null, mobile = null, weight = null, address = null, height = null, dob = null;
    public static String Systolic = null, Diastolic = null, Heart_Rate = null, Cholestrol_LDL = null, Cholestrol_HDL = null, Stress = null, Suger = null, QT_Interval = null, PR_Interval = null, Oxygen_saturation = null, Hemoglobin = null, totalCholestrol = null, cvd = null, cardiac = null, vage = null;
    public static String Systolicv = null, Diastolicv = null, Heart_Ratev = null, Cholestrol_LDLv = null, Cholestrol_HDLv = null, Stressv = null, Sugerv = null, QT_Intervalv = null, PR_Intervalv = null, Oxygen_saturationv = null, Hemoglobinv = null, totalCholestrolv = null, cvdv = null, cardiacv = null, vagev = null, LDL_HDL_Ratio = null, NHDL = null, mapv = null, pulsepressurev = null, bsav = null, bmi = null;
    public static int id1, id2, id3, id4, id5, id6, id7, id8, id9, id10, id11, id12, id13, id14, id15;

    public static void createreport(String id,String msg, String studname) throws SQLException, ParseException {

        //long yourvalue = 135;
       // String yourname = "jitu", yourgender = "Male", yourdr = "Dr.Jitu Patil";
        Document doc = new Document();
        try {

             Connection con = Dbconn.conn();
            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("select * from studentdetails where id='" + id + "'");

            while (rs.next()) {
                pid = rs.getString("id");
                dob = rs.getString("classname");
                pname = rs.getString("name");
                address = rs.getString("addr");
                gender = rs.getString("gender");
            }

            
            PdfWriter.getInstance(doc, new FileOutputStream(reportfile + studname+"_Attendances_Report_" + id + ".pdf"));
            doc.open();
            PdfPTable table1 = new PdfPTable(4);
            PdfPTable table2 = new PdfPTable(7);
            PdfPTable table3 = new PdfPTable(6);
            PdfPTable table4 = new PdfPTable(8);
            PdfPTable table5 = new PdfPTable(2);

            float[] columnWidthsa1 = {1f, 2.5f, 1f, 2.5f}; // Second column will be
            // twice as first and third
            table1.setWidths(columnWidthsa1);

            //Add Image
            Image image1 = Image.getInstance(Dbconn.logos);
            //Fixed Positioning
            image1.setAbsolutePosition(1f, 5f);
            //Scale to new height and new width of image
            image1.scaleAbsolute(50,45);
            //Add to document

            // Patient
            PdfPCell cell40 = new PdfPCell(image1);
            Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.ITALIC | Font.UNDERLINE, BaseColor.RED);
            PdfPCell cellt40 = new PdfPCell(new Phrase("SKNSITS,Lonavala", redFont));
            PdfPCell cell41 = new PdfPCell(new Phrase("Student ID :", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cell42 = new PdfPCell(new Phrase(pid, FontFactory.getFont(FontFactory.HELVETICA, 8)));

            PdfPCell cell59 = new PdfPCell(new Phrase("Student Name:", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cell60 = new PdfPCell(new Phrase(pname, FontFactory.getFont(FontFactory.HELVETICA, 8)));

            PdfPCell cell43 = new PdfPCell(new Phrase("Address :", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cell44 = new PdfPCell(new Phrase(address, FontFactory.getFont(FontFactory.HELVETICA, 8)));

            PdfPCell cell61 = new PdfPCell(new Phrase("Gender :", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cell62 = new PdfPCell(new Phrase(gender, FontFactory.getFont(FontFactory.HELVETICA, 8)));

            PdfPCell cell63 = new PdfPCell(new Phrase("Department :", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cell64 = new PdfPCell(new Phrase(dob, FontFactory.getFont(FontFactory.HELVETICA, 8)));
            Date day = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String strDate = formatter.format(day);
            PdfPCell cellt71 = new PdfPCell(new Phrase("Date :", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cellt72 = new PdfPCell(new Phrase(strDate, FontFactory.getFont(FontFactory.HELVETICA, 8)));

            cellt40.setColspan(3);

            cellt72.setColspan(3);
            //cellt40.setBorderColor(BaseColor.YELLOW);
            cell40.setHorizontalAlignment(Element.ALIGN_LEFT);
            cellt40.setHorizontalAlignment(Element.TITLE);

            cell40.setBorder(Rectangle.NO_BORDER);
            cellt40.setBorder(Rectangle.NO_BORDER);
            cell41.setBorder(Rectangle.NO_BORDER);
            cell42.setBorder(Rectangle.NO_BORDER);
            cell59.setBorder(Rectangle.NO_BORDER);
            cell60.setBorder(Rectangle.NO_BORDER);

            cell43.setBorder(Rectangle.NO_BORDER);
            cell44.setBorder(Rectangle.NO_BORDER);
            cell63.setBorder(Rectangle.NO_BORDER);
            cell64.setBorder(Rectangle.NO_BORDER);
            cell61.setBorder(Rectangle.NO_BORDER);
            cell62.setBorder(Rectangle.NO_BORDER);
            cellt71.setBorder(Rectangle.NO_BORDER);
            cellt72.setBorder(Rectangle.NO_BORDER);
            table1.addCell(cell40);
            table1.addCell(cellt40);
            table1.addCell(cell41);
            table1.addCell(cell42);
            table1.addCell(cell59);
            table1.addCell(cell60);
            table1.addCell(cell43);
            table1.addCell(cell44);
            table1.addCell(cell63);
            table1.addCell(cell64);
            table1.addCell(cell61);
            table1.addCell(cell62);
            table1.addCell(cellt71);
            table1.addCell(cellt72);
            table1.setSpacingAfter(20);
            // Set Column widths of table
            float[] columnWidthsa = {2.5f, 2.5f, 2.5f, 2.5f, 2.5f, 2.5f}; // Second column will be
            // twice as first and third
            table3.setWidths(columnWidthsa);
            float[] columnWidthsa4 = {2.5f, 2.5f, 2.5f, 2.5f, 2.5f, 2.5f, 2.5f, 2.5f}; // Second column will be
            table4.setWidths(columnWidthsa4);
            float[] columnWidthsa2 = {2.5f, 2.5f, 2.5f, 2.5f, 2.5f, 2.5f, 2.5f}; // Second column will be
            table2.setWidths(columnWidthsa2);
//            PdfPCell cell1 = new PdfPCell(new Phrase("Date", FontFactory.getFont(FontFactory.HELVETICA, 8)));
//            PdfPCell cell2 = new PdfPCell(new Phrase("10:00 to 11:00", FontFactory.getFont(FontFactory.HELVETICA, 8)));
//            PdfPCell cell3 = new PdfPCell(new Phrase("11:00 to 12:00", FontFactory.getFont(FontFactory.HELVETICA, 8)));
//            PdfPCell cell4 = new PdfPCell(new Phrase("12:00 to 1:00", FontFactory.getFont(FontFactory.HELVETICA, 8)));
//            PdfPCell cell5 = new PdfPCell(new Phrase("1:30 to 2:30", FontFactory.getFont(FontFactory.HELVETICA, 8)));
//            PdfPCell cell6 = new PdfPCell(new Phrase("2:30 to 3:30", FontFactory.getFont(FontFactory.HELVETICA, 8)));
//            PdfPCell cell7 = new PdfPCell(new Phrase("3:30 to 4:30", FontFactory.getFont(FontFactory.HELVETICA, 8)));
//            PdfPCell cell8 = new PdfPCell(new Phrase("4:30 to 5:30", FontFactory.getFont(FontFactory.HELVETICA, 8)));
//            table3.addCell(cell1);
//            table3.addCell(cell2);
//            table3.addCell(cell3);
//            table3.addCell(cell4);
//            table3.addCell(cell5);
//            table3.addCell(cell6);
//            table3.addCell(cell7);
//            table3.addCell(cell8);
            Random rand = new Random();
          //  String msg;
String a1,a2,a3,a4,a5,a6,a7,a8;
           // Connection con = Dbconn.conn();
            Statement st3 = con.createStatement();
            ResultSet rs1 = st3.executeQuery("select * from tblmasterattendance where id='"+id+"'");
String emailid=null;

if(msg.equals("FE"))
{
	PdfPCell cell1 = new PdfPCell(new Phrase("Day", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    PdfPCell cell2 = new PdfPCell(new Phrase("8:00 to 8:45", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    PdfPCell cell3 = new PdfPCell(new Phrase("8:45 to 9:30", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    PdfPCell cell4 = new PdfPCell(new Phrase("9:30 to 10:15", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    PdfPCell cell5 = new PdfPCell(new Phrase("10:15 to 11:00", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    PdfPCell cell6 = new PdfPCell(new Phrase("11:00 to 12:45", FontFactory.getFont(FontFactory.HELVETICA, 8)));
    table3.addCell(cell1);
    table3.addCell(cell2);
    table3.addCell(cell3);
    table3.addCell(cell4);
    table3.addCell(cell5);
    table3.addCell(cell6);
    
	while (rs1.next()) {
    	emailid=rs1.getString("teacheremailid");
       a1=rs1.getString("h1");
       a2=rs1.getString("h2");
       a3=rs1.getString("h3");
       a4=rs1.getString("h4");
       a5=rs1.getString("h5");
      
   a8=rs1.getString("Day_Name");

        PdfPCell cell9 = new PdfPCell(new Phrase(a8, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell10 = new PdfPCell(new Phrase(a1, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell11 = new PdfPCell(new Phrase(a2, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell12 = new PdfPCell(new Phrase(a3, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell13 = new PdfPCell(new Phrase(a4, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell14 = new PdfPCell(new Phrase(a5, FontFactory.getFont(FontFactory.HELVETICA, 8)));
       
        table3.addCell(cell9);
        table3.addCell(cell10);
        table3.addCell(cell11);
        table3.addCell(cell12);
        table3.addCell(cell13);
        table3.addCell(cell14);
        
    }// while loop end
	
}
else if(msg.equals("SE"))
{
	PdfPCell cell1 = new PdfPCell(new Phrase("Day", FontFactory.getFont(FontFactory.HELVETICA, 8)));
  PdfPCell cell2 = new PdfPCell(new Phrase("8:00 to 8:45", FontFactory.getFont(FontFactory.HELVETICA, 8)));
  PdfPCell cell3 = new PdfPCell(new Phrase("8:45 to 9:30", FontFactory.getFont(FontFactory.HELVETICA, 8)));
  PdfPCell cell4 = new PdfPCell(new Phrase("9:30 to 10:15", FontFactory.getFont(FontFactory.HELVETICA, 8)));
  PdfPCell cell5 = new PdfPCell(new Phrase("10:15 to 11:00", FontFactory.getFont(FontFactory.HELVETICA, 8)));
  PdfPCell cell6 = new PdfPCell(new Phrase("11:00 to 11:45", FontFactory.getFont(FontFactory.HELVETICA, 8)));
  PdfPCell cell7 = new PdfPCell(new Phrase("11:45 to 12:00", FontFactory.getFont(FontFactory.HELVETICA, 8)));
  PdfPCell cell8 = new PdfPCell(new Phrase("12:00 to 12:45", FontFactory.getFont(FontFactory.HELVETICA, 8)));
  table4.addCell(cell1);
  table4.addCell(cell2);
  table4.addCell(cell3);
  table4.addCell(cell4);
  table4.addCell(cell5);
  table4.addCell(cell6);
  table4.addCell(cell7);
  table4.addCell(cell8);
	while (rs1.next()) {
    	emailid=rs1.getString("teacheremailid");
    	a1=rs1.getString("h1");
        a2=rs1.getString("h2");
        a3=rs1.getString("h3");
        a4=rs1.getString("h4");
        a5=rs1.getString("h5");
        a6=rs1.getString("h6");
        a7=rs1.getString("h7");
   a8=rs1.getString("Day_Name");

        PdfPCell cell9 = new PdfPCell(new Phrase(a8, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell10 = new PdfPCell(new Phrase(a1, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell11 = new PdfPCell(new Phrase(a2, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell12 = new PdfPCell(new Phrase(a3, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell13 = new PdfPCell(new Phrase(a4, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell14 = new PdfPCell(new Phrase(a5, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell15 = new PdfPCell(new Phrase(a6, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell16 = new PdfPCell(new Phrase(a7, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        table4.addCell(cell9);
        table4.addCell(cell10);
        table4.addCell(cell11);
        table4.addCell(cell12);
        table4.addCell(cell13);
        table4.addCell(cell14);
        table4.addCell(cell15);
        table4.addCell(cell16);
    }// while loop end
}
else if(msg.equals("TE"))
{
	PdfPCell cell1 = new PdfPCell(new Phrase("Day", FontFactory.getFont(FontFactory.HELVETICA, 8)));
  PdfPCell cell2 = new PdfPCell(new Phrase("8:00 to 9:00", FontFactory.getFont(FontFactory.HELVETICA, 8)));
  PdfPCell cell3 = new PdfPCell(new Phrase("9:00 to 10:00", FontFactory.getFont(FontFactory.HELVETICA, 8)));
  PdfPCell cell4 = new PdfPCell(new Phrase("10:00 to 11:00", FontFactory.getFont(FontFactory.HELVETICA, 8)));
  PdfPCell cell5 = new PdfPCell(new Phrase("11:30 to 12:30", FontFactory.getFont(FontFactory.HELVETICA, 8)));
  PdfPCell cell6 = new PdfPCell(new Phrase("12:30 to 1:30", FontFactory.getFont(FontFactory.HELVETICA, 8)));
  PdfPCell cell7 = new PdfPCell(new Phrase("1:30 to 2:30", FontFactory.getFont(FontFactory.HELVETICA, 8)));
   table2.addCell(cell1);
  table2.addCell(cell2);
  table2.addCell(cell3);
  table2.addCell(cell4);
  table2.addCell(cell5);
  table2.addCell(cell6);
  table2.addCell(cell7);
  
	while (rs1.next()) {
    	emailid=rs1.getString("teacheremailid");
    	a1=rs1.getString("h1");
        a2=rs1.getString("h2");
        a3=rs1.getString("h3");
        a4=rs1.getString("h4");
        a5=rs1.getString("h5");
        a6=rs1.getString("h6");
   a8=rs1.getString("Day_Name");

        PdfPCell cell9 = new PdfPCell(new Phrase(a8, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell10 = new PdfPCell(new Phrase(a1, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell11 = new PdfPCell(new Phrase(a2, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell12 = new PdfPCell(new Phrase(a3, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell13 = new PdfPCell(new Phrase(a4, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell14 = new PdfPCell(new Phrase(a5, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell15 = new PdfPCell(new Phrase(a6, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        table2.addCell(cell9);
        table2.addCell(cell10);
        table2.addCell(cell11);
        table2.addCell(cell12);
        table2.addCell(cell13);
        table2.addCell(cell14);
        table2.addCell(cell15);
       
    }// while loop end	

}
else if(msg.equals("BE"))
{
	PdfPCell cell1 = new PdfPCell(new Phrase("Day", FontFactory.getFont(FontFactory.HELVETICA, 8)));
	  PdfPCell cell2 = new PdfPCell(new Phrase("8:00 to 9:00", FontFactory.getFont(FontFactory.HELVETICA, 8)));
	  PdfPCell cell3 = new PdfPCell(new Phrase("9:00 to 10:00", FontFactory.getFont(FontFactory.HELVETICA, 8)));
	  PdfPCell cell4 = new PdfPCell(new Phrase("10:00 to 11:00", FontFactory.getFont(FontFactory.HELVETICA, 8)));
	  PdfPCell cell5 = new PdfPCell(new Phrase("11:30 to 12:30", FontFactory.getFont(FontFactory.HELVETICA, 8)));
	  PdfPCell cell6 = new PdfPCell(new Phrase("12:30 to 1:30", FontFactory.getFont(FontFactory.HELVETICA, 8)));
	  PdfPCell cell7 = new PdfPCell(new Phrase("1:30 to 2:30", FontFactory.getFont(FontFactory.HELVETICA, 8)));
	   table2.addCell(cell1);
	  table2.addCell(cell2);
	  table2.addCell(cell3);
	  table2.addCell(cell4);
	  table2.addCell(cell5);
	  table2.addCell(cell6);
	  table2.addCell(cell7);
	
	while (rs1.next()) {
    	emailid=rs1.getString("teacheremailid");
    	a1=rs1.getString("h1");
        a2=rs1.getString("h2");
        a3=rs1.getString("h3");
        a4=rs1.getString("h4");
        a5=rs1.getString("h5");
        a6=rs1.getString("h6");
        
   a8=rs1.getString("Day_Name");

        PdfPCell cell9 = new PdfPCell(new Phrase(a8, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell10 = new PdfPCell(new Phrase(a1, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell11 = new PdfPCell(new Phrase(a2, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell12 = new PdfPCell(new Phrase(a3, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell13 = new PdfPCell(new Phrase(a4, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell14 = new PdfPCell(new Phrase(a5, FontFactory.getFont(FontFactory.HELVETICA, 8)));
        PdfPCell cell15 = new PdfPCell(new Phrase(a6, FontFactory.getFont(FontFactory.HELVETICA, 8)));
         table2.addCell(cell9);
        table2.addCell(cell10);
        table2.addCell(cell11);
        table2.addCell(cell12);
        table2.addCell(cell13);
        table2.addCell(cell14);
        table2.addCell(cell15);
       
    }// while loop end

}
//            while (rs1.next()) {
//            	emailid=rs1.getString("Teacher_Email_ID");
//               a1=rs1.getString("10:00_11:00_time");
//               a2=rs1.getString("11:00_12:00_time");
//               a3=rs1.getString("12:00_1:00_time");
//               a4=rs1.getString("1:30_2:30_time");
//               a5=rs1.getString("2:30_3:30_time");
//               a6=rs1.getString("3:30_4:30_time");
//               a7=rs1.getString("4:30_5:30_time");
//           a8=rs1.getString("Day");
//     
//                PdfPCell cell9 = new PdfPCell(new Phrase(a8, FontFactory.getFont(FontFactory.HELVETICA, 8)));
//                PdfPCell cell10 = new PdfPCell(new Phrase(a1, FontFactory.getFont(FontFactory.HELVETICA, 8)));
//                PdfPCell cell11 = new PdfPCell(new Phrase(a2, FontFactory.getFont(FontFactory.HELVETICA, 8)));
//                PdfPCell cell12 = new PdfPCell(new Phrase(a3, FontFactory.getFont(FontFactory.HELVETICA, 8)));
//                PdfPCell cell13 = new PdfPCell(new Phrase(a4, FontFactory.getFont(FontFactory.HELVETICA, 8)));
//                PdfPCell cell14 = new PdfPCell(new Phrase(a5, FontFactory.getFont(FontFactory.HELVETICA, 8)));
//                PdfPCell cell15 = new PdfPCell(new Phrase(a6, FontFactory.getFont(FontFactory.HELVETICA, 8)));
//                PdfPCell cell16 = new PdfPCell(new Phrase(a7, FontFactory.getFont(FontFactory.HELVETICA, 8)));
//                table3.addCell(cell9);
//                table3.addCell(cell10);
//                table3.addCell(cell11);
//                table3.addCell(cell12);
//                table3.addCell(cell13);
//                table3.addCell(cell14);
//                table3.addCell(cell15);
//                table3.addCell(cell16);
//            }// while loop end
            
            Statement st2 = con.createStatement();
            System.out.println("EmailID=>"+emailid);
            ResultSet rs2 = st2.executeQuery("select * from teacherdetails where email='"+emailid+"'");
String teachername=null;
            if (rs2.next()) {
            	teachername=rs2.getString("name");
            }            
            System.out.println("teachername=>"+teachername);
            PdfPCell cella59 = new PdfPCell(new Phrase("", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella60 = new PdfPCell(new Phrase(teachername, FontFactory.getFont(FontFactory.HELVETICA, 8)));
            //  cella59.setColspan(2);

            PdfPCell cella61 = new PdfPCell(new Phrase("", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            PdfPCell cella62 = new PdfPCell(new Phrase("Sign", FontFactory.getFont(FontFactory.HELVETICA, 8)));
            cella60.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cella62.setHorizontalAlignment(Element.ALIGN_RIGHT);

            cella59.setBorder(Rectangle.NO_BORDER);
            cella60.setBorder(Rectangle.NO_BORDER);
            cella61.setBorder(Rectangle.NO_BORDER);
            cella62.setBorder(Rectangle.NO_BORDER);
            table3.setSpacingAfter(24);
            table5.addCell(cella59);
            table5.addCell(cella60);
            table5.addCell(cella61);
            table5.addCell(cella62);
            doc.add(table1);
            doc.add(table3);
            doc.add(table2);
            doc.add(table4);
            doc.add(table5);

        } catch (DocumentException | FileNotFoundException e) {
        	System.out.println(e);
        } catch (SQLException ex) {
           System.out.println(ex);
        } catch (ClassNotFoundException ex) {
        	System.out.println(ex);
        } catch (IOException ex) {
        	System.out.println(ex);
        } finally {
            doc.close();
        }
    }
}
