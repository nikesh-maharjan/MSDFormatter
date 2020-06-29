package com.nikesh;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import javafx.beans.binding.ObjectBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;

public class Controller implements Initializable {

	Model model = new Model();
	View view = new View();
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		initDataTypes();
		initTable();
		initPlatform();
	}

	private void initPlatform() {
		
		tree_platform.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		tree_platform.setRoot(view.rootTreeItem);
	}

	/********************* DATA Type Table **********************/
	@FXML
	private ComboBox<String> cb1;
	@FXML
	private ComboBox<String> cb2;
	@FXML
	private ComboBox<String> cb3;
	@FXML
	private ComboBox<String> cb4;
	@FXML
	private ComboBox<String> cb5;
	@FXML
	private ComboBox<String> cb6;
	
	@FXML
	private Label lbl_dataType;

	private void initDataTypes() {

		lbl_dataType.setTextAlignment(TextAlignment.CENTER);
		
		cb1.setItems(model.dataTypes);
		cb2.setItems(model.dataTypes);
		cb3.setItems(model.dataTypes);
		cb4.setItems(model.dataTypes);
		cb5.setItems(model.dataTypes);
		cb6.setItems(model.dataTypes);
		
		cb1.setPromptText("Select item");
		cb2.setPromptText("Select item");
		cb3.setPromptText("Select item");
		cb4.setPromptText("Select item");
		cb5.setPromptText("Select item");
		cb6.setPromptText("Select item");

	}
	
	private String getDataType(int comboBoxIndex) {
		
		switch (comboBoxIndex+1) {
		case 1:
			return cb1.getSelectionModel().getSelectedItem();
		case 2:
			return cb2.getSelectionModel().getSelectedItem();
		case 3:
			return cb3.getSelectionModel().getSelectedItem();
		case 4:
			return cb4.getSelectionModel().getSelectedItem();
		case 5:
			return cb5.getSelectionModel().getSelectedItem();
		case 6:
			return cb6.getSelectionModel().getSelectedItem();
		default:
			return "";
		}
	}
	
	/********************* DATA table **************************/

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;
	
	@FXML
	private TableView<GenericTableRecord> table_view;
	@FXML // fx:id="col1"
	private TableColumn<GenericTableRecord, String> col1; // Value injected by FXMLLoader
	@FXML // fx:id="col2"
	private TableColumn<GenericTableRecord, String> col2; // Value injected by FXMLLoader
	@FXML // fx:id="col3"
	private TableColumn<GenericTableRecord, String> col3; // Value injected by FXMLLoader
	@FXML // fx:id="col4"
	private TableColumn<GenericTableRecord, String> col4; // Value injected by FXMLLoader
	@FXML // fx:id="col5"
	private TableColumn<GenericTableRecord, String> col5; // Value injected by FXMLLoader
	@FXML // fx:id="col6"
	private TableColumn<GenericTableRecord, String> col6; // Value injected by FXMLLoader

	private void initTable() {
		initCols();
		table_view.setItems(model.data_table);
		model.loadData();
	}

	public void initCols() {

		// Set table Column Cell Property
		col1.setCellValueFactory(
				(TableColumn.CellDataFeatures<GenericTableRecord, String> param) -> param.getValue().col1_property());
		col2.setCellValueFactory(
				(TableColumn.CellDataFeatures<GenericTableRecord, String> param) -> param.getValue().col2_property());
		col3.setCellValueFactory(
				(TableColumn.CellDataFeatures<GenericTableRecord, String> param) -> param.getValue().col3_property());
		col4.setCellValueFactory(
				(TableColumn.CellDataFeatures<GenericTableRecord, String> param) -> param.getValue().col4_property());
		col5.setCellValueFactory(
				(TableColumn.CellDataFeatures<GenericTableRecord, String> param) -> param.getValue().col5_property());
		col6.setCellValueFactory(
				(TableColumn.CellDataFeatures<GenericTableRecord, String> param) -> param.getValue().col6_property());
		
//		col1.setCellValueFactory(new PropertyValueFactory<>("col1")); // another way to set columnCellValueFactory 

		editableCols();
	}

	public void editableCols() {

		col1.setCellFactory(TextFieldTableCell.forTableColumn());
		col1.setOnEditCommit(e -> {
			GenericTableRecord currentEditingRecord = e.getTableView().getItems().get(e.getTablePosition().getRow());
			currentEditingRecord.setCol1(e.getNewValue());
		});

		col2.setCellFactory(TextFieldTableCell.forTableColumn());
		col2.setOnEditCommit(e -> {
			GenericTableRecord currentEditingRecord = e.getTableView().getItems().get(e.getTablePosition().getRow());
			currentEditingRecord.setCol2(e.getNewValue());
		});

		col3.setCellFactory(TextFieldTableCell.forTableColumn());
		col3.setOnEditCommit(e -> {
			GenericTableRecord currentEditingRecord = e.getTableView().getItems().get(e.getTablePosition().getRow());
			currentEditingRecord.setCol3(e.getNewValue());
		});

		col4.setCellFactory(TextFieldTableCell.forTableColumn());
		col4.setOnEditCommit(e -> {
			GenericTableRecord currentEditingRecord = e.getTableView().getItems().get(e.getTablePosition().getRow());
			currentEditingRecord.setCol4(e.getNewValue());
		});
		
		col5.setCellFactory(TextFieldTableCell.forTableColumn());
		col5.setOnEditCommit(e -> {
			GenericTableRecord currentEditingRecord = e.getTableView().getItems().get(e.getTablePosition().getRow());
			currentEditingRecord.setCol5(e.getNewValue());
		});
		
		col6.setCellFactory(TextFieldTableCell.forTableColumn());
		col6.setOnEditCommit(e -> {
			GenericTableRecord currentEditingRecord = e.getTableView().getItems().get(e.getTablePosition().getRow());
			currentEditingRecord.setCol6(e.getNewValue());
		});

		table_view.setEditable(true);
		
		// allow updating cell when the focus changes to enhance user experience
		// Note this override above cell factory property
		Callback<TableColumn<GenericTableRecord, String>,TableCell<GenericTableRecord, String>> cellFactory =
					(TableColumn<GenericTableRecord, String> p) -> new EditingCell();
		col1.setCellFactory(cellFactory); 
		col2.setCellFactory(cellFactory);
		col3.setCellFactory(cellFactory); 
		col4.setCellFactory(cellFactory);
		col5.setCellFactory(cellFactory); 
		col6.setCellFactory(cellFactory);
		 
	}
	
//	public static ObservableList<GenericTableRecord> data_table;
	
	/********************** Controls ******************************************/
	
	@FXML
	private TextArea txtArea_msd_data;
	
	public void addNewRow(ActionEvent e) {
		System.out.println("Button was clicked");
		GenericTableRecord newRecord = new GenericTableRecord();
		model.data_table.add(newRecord);
		table_view.getSelectionModel().select(model.data_table.size()-1); // select new Row
	}
	
	public void generateSQL(ActionEvent e) {

		int numberOfColumns = table_view.getColumns().size();
		int numberOfRows = model.data_table.size();
		
		txtArea_msd_data.clear();
		txtArea_msd_data.setStyle("-fx-text-fill: black; -fx-font-size: 14px;");
		
		txtArea_msd_data.appendText(
				"/*******************************************************************************\n" +
				"Number of Rows: " + numberOfRows + ", Number of Columns: " + numberOfColumns +
				"\n*******************************************************************************/\n\n");
		ObservableList<GenericTableRecord> records = FXCollections.observableArrayList(model.data_table);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numberOfRows; i++) {
			if (i != 0) { sb.append(",\n" ); }
			GenericTableRecord record = records.get(i);
			for (int j = 0; j < numberOfColumns; j++) {
				
				String dataType = getDataType(j); // Combo Boxes are indexed starting from 0
				String data = record.getColumn(j);
				
				if (dataType == "" || dataType == null) {
					txtArea_msd_data.setText("Data Type was not selected for Column " + (j+1));
					txtArea_msd_data.setStyle("-fx-text-fill: red; -fx-font-size: 20px;");
					return;
				} else if (dataType.equalsIgnoreCase("String")) {
					data = "'" + data + "'";
				} else if (dataType.equalsIgnoreCase("Integer")) {
					try{
						Integer.parseInt(data);
					} catch (NumberFormatException ex) {
						txtArea_msd_data.setText("Value in Row: " + (i+1) + ", Column: " + (j+1)
								+ " is not an Integer.");
						txtArea_msd_data.setStyle("-fx-text-fill: red; -fx-font-size: 20px;");
						return;
					}
				} else if (dataType.equalsIgnoreCase("New Guid")) {
					String newGuid = UUID.randomUUID().toString();
					model.data_table.get(i).setColumn(j, newGuid);
					data = "'" + model.data_table.get(i).getColumn(j) + "'";
				}
				
				if (j == 0) { 
					sb.append( "(" + data + ", "); // columns are indexed starting from 0
				} else if(j == numberOfColumns - 1) {
					sb.append(data + ")" );
				} else {
					sb.append(data + ", "); // columns are indexed starting from 0
				}
				
			}
		}
		txtArea_msd_data.appendText(sb.toString());
	}
	
	public void exitApp(ActionEvent e) {
		System.exit(0);
	}
	
	/***************** Misc **************************************************/
	@FXML
	private TreeView<String> tree_platform;
}
