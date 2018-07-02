package com.assetmanagementsystem.model.service;

import java.security.Key;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.assetmanagementsystem.model.dao.EmployeeDao;
import com.assetmanagementsystem.model.entity.EmployeeEntity;

public class EmployeeDaoService {
	
	EmployeeDao edao=new EmployeeDao();
	
	public int addEmployee(EmployeeEntity e) {
		return edao.addEmployee(e);
	}
	
	public boolean updateEmployee(EmployeeEntity e) {
		return edao.updateEmployee(e);
	}
	
	public boolean checkLogin(String username, String password, String department) {
		String securePassword = passAES(password);
		return edao.checkLogin(username, securePassword, department);
	}
	
	public EmployeeEntity displayEmployeeByEno(int eno) {
		return edao.displayEmployeeByEno(eno);
	}
	
	public EmployeeEntity displayEmployeeByUsername(String username) {
		return edao.displayEmployeeByUsername(username);
	}
	
	public boolean deleteEmployee(int eno) {
		return edao.deleteEmployee(eno);
	}
	
	public boolean changePassword(int eno, String password) {
		String securePassword = passAES(password);
		return edao.changePassword(eno, securePassword);
	}
	
	public boolean changePhoneNumber(int eno, long phoneNo) {
		return edao.changePhoneNumber(eno, phoneNo);
	}
	
	public String[] generatePassword() {
		 char[] rand = {'{','!','@','#','$','%','%','&','}','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X',
					'Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','p','q','r','s','t','u','v','w','x','y','z','1','2','3','4','5','6','7','8','9','0'};
		   
		char[] ch=new char[8];
		for(int i=0;i<8;i++) {
			ch[i]= rand[(int) Math.floor(Math.random()*rand.length)];
		}
		
		String[] passwordArray = new String[2];
		
		String pass = String.valueOf(ch);	
		String encryptedPass = passAES(pass);
		
		passwordArray[0] = pass;
		passwordArray[1] = encryptedPass;
		
		return passwordArray;
	}

//	AES password encryption
	public String passAES(String normalPassword) {
		
		String inputPassword = normalPassword;
		String key = "AVN@15032018@AMS"; // 128 bit key
		byte[] encrypted = null;
		
		try {    
	        // Create key and cipher
	        Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
	        Cipher cipher = Cipher.getInstance("AES");
	        // encrypt the text
	        
	        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
	        encrypted = cipher.doFinal(inputPassword.getBytes());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return new String(encrypted);
	}
	
	public List<EmployeeEntity> listEmployeeByManager(int mId) {
		return edao.listEmployeeByManager(mId);
	}
}
