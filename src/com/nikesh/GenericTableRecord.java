package com.nikesh;

import javafx.beans.property.SimpleStringProperty;

public class GenericTableRecord {

	private SimpleStringProperty col1 = new SimpleStringProperty("");
	private SimpleStringProperty col2 = new SimpleStringProperty("");
	private SimpleStringProperty col3 = new SimpleStringProperty("");
	private SimpleStringProperty col4 = new SimpleStringProperty("");
	private SimpleStringProperty col5 = new SimpleStringProperty("");
	private SimpleStringProperty col6 = new SimpleStringProperty("");
//	private final SimpleStringProperty col1 = new SimpleStringProperty("");
//	private final SimpleStringProperty col2 = new SimpleStringProperty("");
//	private final SimpleStringProperty col3 = new SimpleStringProperty("");
//	private final SimpleStringProperty col4 = new SimpleStringProperty("");
//	private final SimpleStringProperty col5 = new SimpleStringProperty("");
//	private final SimpleStringProperty col6 = new SimpleStringProperty("");
	
	public GenericTableRecord() {
		this("","","","","","");
	}
	public GenericTableRecord(String col1, String col2, String col3, String col4, String col5, String col6) {
		super();
		this.col1.set(col1);
		this.col2.set(col2);
		this.col3.set(col3);
		this.col4.set(col4);
		this.col5.set(col5);
		this.col6.set(col6);
	}
	
	/******* String Property ************************/
	
	public SimpleStringProperty col1_property() { return col1; }
	public SimpleStringProperty col2_property() { return col2; }
	public SimpleStringProperty col3_property() { return col3; }
	public SimpleStringProperty col4_property() { return col4; }
	public SimpleStringProperty col5_property() { return col5; }
	public SimpleStringProperty col6_property() { return col6; }
	
	/**************** Getters *************************/
	
	public String getColumn(int columnIndex) { 
		switch (columnIndex+1) {
		case 1:
			return col1.get();
		case 2:
			return col2.get();
		case 3:
			return col3.get();
		case 4:
			return col4.get();
		case 5:
			return col5.get();
		case 6:
			return col6.get();
		default:
			break;
		}
		return col1.get(); 
	}
	public String getCol1() { return col1.get(); }
	public String getCol2() { return col2.get(); }
	public String getCol3() { return col3.get(); }
	public String getCol4() { return col4.get(); }
	public String getCol5() { return col5.get(); }
	public String getCol6() { return col6.get(); }
	
	/**************** Setters *************************/
	public void setColumn(int columnIndex, String value) { 
		switch (columnIndex + 1) {
		case 1:
			col1.set(value);
			break;
		case 2:
			col2.set(value);
			break;
		case 3:
			col3.set(value);
			break;
		case 4:
			col4.set(value);
			break;
		case 5:
			col5.set(value);
			break;
		case 6:
			col6.set(value);
			break;
		default:
			break;
		}
	}
	public void setCol1(String col1) { this.col1.setValue(col1); }
	public void setCol2(String col2) { this.col2.setValue(col2); }
	public void setCol3(String col3) { this.col3.setValue(col3); }
	public void setCol4(String col4) { this.col4.setValue(col4); }
	public void setCol5(String col5) { this.col5.setValue(col5); }
	public void setCol6(String col6) { this.col6.setValue(col6); }
}
