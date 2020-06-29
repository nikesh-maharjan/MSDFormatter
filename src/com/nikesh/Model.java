package com.nikesh;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
	
	public ObservableList<GenericTableRecord> data_table = FXCollections.observableArrayList();;
	public ObservableList<String> dataTypes = 
			FXCollections.observableArrayList("String", "Integer", "New Guid");;
	
	public void loadData() {
		for (int i = 0; i < 7; i++) {
			data_table.add(new GenericTableRecord("R" + i + " C1", "R" + i + " C2", "R" + i + " C3", 
				"R" + i + " C4", "R" + i + " C5", "R" + i + " C6"));
		}
	}
}
