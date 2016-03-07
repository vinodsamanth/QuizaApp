package quizaApp.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.xml.crypto.Data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import quizaApp.Model.DBconnect;
import quizaApp.Model.Professor;

public class GraphResultShowController implements Initializable{

	private final Professor professor;
	private final String selectedOption;
	private int[] resultArray;
	
	@FXML
	private PieChart pieChart;
	
	public GraphResultShowController(String selectedOption, Professor professor) {
//		System.out.println("Graph Result Show");
		// TODO Auto-generated constructor stub
		this.professor = professor;
		this.selectedOption = selectedOption;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		DBconnect db = new DBconnect();
		int[] resultGraph = db.getGraphResult(selectedOption);
		if(resultGraph == null)
			return;
		
		int belowThree = 0;
		int betweenThreeFive = 0;
		int betweenFiveSeven = 0;
		int aboveSeven = 0;
		
		for(int i : resultGraph){
			if( i <= 3)
				belowThree++;
			if(i > 3 & i <= 5)
				betweenThreeFive++;
			if(i > 5 & i <= 7)
				betweenFiveSeven++;
			if( i > 7)
				aboveSeven++;
		}
		
		ObservableList<PieChart.Data> pieChartData = 
                FXCollections.observableArrayList(
                    new PieChart.Data("Below 3", belowThree),
                    new PieChart.Data("Between 3 and 5", betweenThreeFive),
                    new PieChart.Data("Between 5 and 7", betweenFiveSeven),
                    new PieChart.Data("Above 7", aboveSeven));
		
		pieChart.setData(pieChartData);
	}
	
	

}
