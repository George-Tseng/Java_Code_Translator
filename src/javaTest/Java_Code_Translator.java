package javaTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Java_Code_Translator {
	public static void main(String[] args) {
		
		Scanner inputScan = new Scanner(System.in);
		String inputFileRoute, outputFileRoute, modeCover, modeCovert;
		File inputFile, outputFile;
		boolean keepRun1 = false, keepRun2 = false, keepRun3 = false, keepRun4 = false, keepRun5 = false;
		
		System.out.println("在開始操作前，請先確認檔案所使用的編碼\n如不確定檔案編碼，建議在接下來的流程中不要選擇任何涉及到檔案覆蓋的選項\n");
		/*Part 1 收集要匯入的檔案路徑*/
		do {
			do {
				System.out.println("請先輸入欲匯入的檔案完整路徑：");
				inputFileRoute = inputScan.nextLine();
			
				if(inputFileRoute.equals("")) {
					keepRun1 = true;
					System.out.println("發生錯誤！請重新輸入！");
				}
				else {
					keepRun1 = false;
				}
			}
			while(keepRun1);
		
			/*Part 2 檢查檔案是否存在*/
			inputFile = new File(inputFileRoute);
			if(inputFile.exists() == true) {
				keepRun2 = false;
				System.out.println("匯入檔案路徑正確...");
			}
			else {
				System.out.println("指定路徑上的檔案不存在！請重新輸入！");
				keepRun1 = true;
				keepRun2 = true;
			}
		}
		while(keepRun2);
		
		/*Part 3 收集要匯出的檔案路徑*/
		do {
			do {
				System.out.println("請再輸入欲匯出的檔案完整路徑：");
				outputFileRoute = inputScan.nextLine();
			
				if(outputFileRoute.equals("")) {
					keepRun3 = true;
					System.out.println("發生錯誤！請重新輸入！");
				}
				else {
					keepRun3 = false;
				}
			}
			while(keepRun3);
		
			/*Part 4 檢查檔案是否存在*/
			outputFile = new File(outputFileRoute);
			
			if(outputFile.exists() == true) {
				if(outputFile.getPath().equals(inputFile.getPath()) == true) {
					/*是否覆蓋原檔*/
					System.out.println("指定路徑上的特定檔案已存在！請問是否要直接覆蓋(Y/N)？預設為否(N)");
					modeCover = inputScan.nextLine();
					
					if(modeCover.equals("") == true || modeCover.equals("N") == true || modeCover.equals("n") == true) {
						keepRun4 = true;
						System.out.println("重新選擇匯出的檔案路徑與名稱...");
					}
					else if(modeCover.equals("Y") == true || modeCover.equals("y") == true){
						keepRun4 = false;
						System.out.println("匯出的檔案將會取代原檔...");
					}
					else {
						keepRun4 = true;
						System.out.println("無效的輸入參數！請重新輸入");
					}
				}
				else{
					/*是否覆蓋該檔*/
					System.out.println("指定路徑上的檔案已存在！請問是否要直接覆蓋(Y/N)？預設為否(N)");
					modeCover = inputScan.nextLine();
					
					if(modeCover.equals("") == true || modeCover.equals("N") == true || modeCover.equals("n") == true) {
						keepRun4 = true;
						System.out.println("重新選擇匯出的檔案路徑與名稱...");
					}
					else if(modeCover.equals("Y") == true || modeCover.equals("y") == true){
						keepRun4 = false;
						System.out.println("匯出的檔案將會取代該檔案...");
					}
					else {
						keepRun4 = true;
						System.out.println("無效的輸入參數！請重新輸入");
					}
				}
			}
			else {
				keepRun4 = false;
				System.out.println("匯出檔案路徑正確...");
			}
		}
		while(keepRun4);
		
		/*Part 5 決定轉換模式*/
		do {
			System.out.println("請選擇輸入下列整數以選擇轉換模式：");
			System.out.println("1. MS950 轉成 UTF-8\n2. UTF-8 轉成 MS950\n3. UTF-8 轉成 MS950 (使用 4 位元進行轉換)");
			System.out.println("4. GBK 轉成 UTF-8\n2. UTF-8 轉成 GBK\n6. UTF-8 轉成 GBK (使用 4 位元進行轉換)):");
			System.out.println("7. MS950 轉成 GBK\n8. GBK 轉成 MS950\n(預設為 1):");
			modeCovert = inputScan.nextLine();
				
			if(modeCovert.equals("") == true || modeCovert.equals("1") == true) {
				keepRun5 = false;
			}
			else if(modeCovert.equals("2") == true || modeCovert.equals("3") == true) {
				keepRun5 = false;
			}
			else if(modeCovert.equals("4") == true) {
				keepRun5 = false;
			}
			else if(modeCovert.equals("5") == true || modeCovert.equals("6") == true) {
				keepRun5 = false;
			}
			else if(modeCovert.equals("7") == true) {
				keepRun5 = false;
			}
			else if(modeCovert.equals("8") == true) {
				keepRun5 = false;
			}
			else {
				keepRun5 = true;
				System.out.println("無效的輸入參數！請重新輸入");
			}
		}
		while(keepRun5);
		
		/*Part 6 開始轉換*/
		if(modeCovert.equals("") == true || modeCovert.equals("1") == true) {
			charsetTranslate(inputFile, outputFile, "MS950", "UTF-8", 1);
		}
		else if(modeCovert.equals("2") == true) {
			charsetTranslate(inputFile, outputFile, "UTF-8", "MS950", 2);
		}
		else if(modeCovert.equals("3") == true) {
			charsetTranslate(inputFile, outputFile, "UTF-8", "MS950", 3);
		}
		else if(modeCovert.equals("4") == true) {
			charsetTranslate(inputFile, outputFile, "GBK", "UTF-8", 4);
		}
		else if(modeCovert.equals("5") == true) {
			charsetTranslate(inputFile, outputFile, "UTF-8", "GBK", 5);
		}
		else if(modeCovert.equals("6") == true) {
			charsetTranslate(inputFile, outputFile, "UTF-8", "GBK", 6);
		}
		else if(modeCovert.equals("7") == true) {
			charsetTranslate(inputFile, outputFile, "MS950", "GBK", 7);
		}
		else if(modeCovert.equals("8") == true) {
			charsetTranslate(inputFile, outputFile, "GBK", "MS950", 8);
		}
		else {
			System.out.println("發生未知的錯誤！請重新執行！");
		}
		
		inputScan.close();
	}
	
	static void charsetTranslate(File inputF, File outputF, String inputChar, String outputChar, int mode){
		try (
				/*讀取*/
				InputStreamReader isr0 = new InputStreamReader(new FileInputStream(inputF), inputChar);
				/*寫入*/
				OutputStreamWriter osw0 = new OutputStreamWriter(new FileOutputStream(outputF), outputChar);
			){
				int count;
				char [] charSpace;
				switch(mode) {
					case 1:
					case 7:
						/*MS950 2 bit*/
			            charSpace = new char[2];
			            while((count = isr0.read(charSpace)) != -1){
			                osw0.write(charSpace, 0, count);
			            }
			            break;
					case 2:
					case 5:
						/*UTF-8 3 bit*/
			            charSpace = new char[3];
			            while((count = isr0.read(charSpace)) != -1){
			                osw0.write(charSpace, 0, count);
			            }
			            break;
					case 3:
					case 6:
						/*UTF-8 4 bit*/
			            charSpace = new char[4];
			            while((count = isr0.read(charSpace)) != -1){
			                osw0.write(charSpace, 0, count);
			            }
			            break;
					case 4:
					case 8:
						/*GBK 2 bit*/
			            charSpace = new char[2];
			            while((count = isr0.read(charSpace)) != -1){
			                osw0.write(charSpace, 0, count);
			            }
			            break;
				}
				System.out.println("轉換工作已完成，檔案路徑為："+outputF);
	            
	            isr0.close();
	            osw0.flush();
	            osw0.close();
			}
			catch(UnsupportedEncodingException excep0) {
				excep0.printStackTrace();
			}
			catch(FileNotFoundException excep1) {
				excep1.printStackTrace();
			}
			catch(IOException excep2) {
				excep2.printStackTrace();
			}
	}
}