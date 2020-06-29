package com.nikesh;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class View {

	public TreeItem<String> rootTreeItem = new TreeItem<String>("Platforms");
	
	public final Node icon_mysql = new ImageView(new Image(getClass().getResourceAsStream("mysql.png"), 40, 40, true, true ));  
	public final Node icon_mssql = new ImageView(new Image(getClass().getResourceAsStream("mssql.png"), 40, 40, true, true ));  
	
	public View() {
		this.intialize();
	}

	private void intialize() {
		
		TreeItem<String> mssql = new TreeItem<String>("MS SQL Server", this.icon_mssql);
		TreeItem<String> mysql = new TreeItem<String>("MY SQL", this.icon_mysql);
		
		rootTreeItem.getChildren().addAll(mssql, mysql);
		rootTreeItem.setExpanded(true);
	}
	
}
