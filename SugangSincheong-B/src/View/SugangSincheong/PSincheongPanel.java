package View.SugangSincheong;

import java.util.Vector;

import Service.SSincheong;
import ValueObject.VLecture;
import ValueObject.VSincheong;

public class PSincheongPanel extends PLectureTable {
	private static final long serialVersionUID = 1L;
	
	SSincheong sSincheong = new SSincheong();
	boolean checkLog;
	
	public PSincheongPanel() {
		super("department/");
		checkLog = sSincheong.initCheck();
		
		if (checkLog == true) { //파일의 내용이 있는지 확인 
			setInitMiridamgi();
		}
	}

	public void setLectures (VSincheong vSincheong) {
		Vector<String> row = new Vector<String>();
        row.add(vSincheong.getId());
        row.add(vSincheong.getName());
        row.add(vSincheong.getProfessor());
        row.add(vSincheong.getCredit());
        row.add(vSincheong.getTime());
        this.tableModel.addRow(row);
	}
	
	public void setInitMiridamgi () { //예전 내역을 파일에서 불러와서 화면에 그린다.
		Vector<VSincheong> initData = sSincheong.getInitSincheong();
		
		for (int i = 0; initData.size() > i; i++) {
			Vector<String> row = new Vector<String>(); //초기화를 위해 for문 안에 선언
			  	row.add(initData.get(i).getId());
		        row.add(initData.get(i).getName());
		        row.add(initData.get(i).getProfessor());
		        row.add(initData.get(i).getCredit());
		        row.add(initData.get(i).getTime());
		        
		        this.tableModel.addRow(row);
		}
	}

	public void addLectures(Vector<VLecture> lectures) {
		VSincheong vSincheong = new VSincheong(); 
		sSincheong = new SSincheong(); 
		
		vSincheong.setId(lectures.get(0).getId());
		vSincheong.setName(lectures.get(0).getName());
		vSincheong.setProfessor(lectures.get(0).getProfessor());
		vSincheong.setCredit(lectures.get(0).getCredit());
		vSincheong.setTime(lectures.get(0).getTime());
		
		sSincheong.addMiridamgi(vSincheong);
		setLectures(vSincheong);
	}

	public Vector<VLecture> getSelectedLecture() {
		return this.getData(this.getSelectedRows()[0]); 
	}

}
