package com.ktds.pingpong.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ktds.pingpong.chat.vo.ChatVO;

public class SplitTextFile {

	public static final int DATE = 0;
	public static final int NAME = 1;
	public static final int CHAT = 2;

	public List<ChatVO> splitTextFile(File upfile) {
		ChatVO text = null;
		String temp = "";
		String[] chat = null;
		BufferedReader br = null;
		boolean flag = false;
		boolean checkCount = false;
		List<ChatVO> chatList = null;
		
		// split 짜르는 법 http://blog.naver.com/geeyoming/220104022469
		try {
			FileInputStream fis = new FileInputStream(upfile);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);

			chatList = new ArrayList<ChatVO>();

			Pattern d = Pattern.compile("^([0-9]{4}년) ([0-9]{1,2}월) ([0-9]{1,2}일) (오전|오후) ([0-9]{1,2}):([0-9]{2})$");

			while ((temp = br.readLine()) != null) {

				if (temp.contains(",")) {
					if (temp.contains(" : ")) {
						chat = temp.split(",| :");

						Matcher m = d.matcher(chat[DATE]);
						flag = m.matches();

						if (flag == true) {
							if (chat[NAME] != null) {
								if (chat[CHAT] != null) {
									chat[DATE] = chat[DATE].trim();
									chat[NAME] = chat[NAME].trim();
									chat[CHAT] = chat[CHAT].trim();
									checkCount = false;
								}
							}
						}
					}

				} else {
					if (chat != null) {
						if (chat.length > 0) {
							chat[CHAT] += temp;
							checkCount = true;
						}
					}
				}

				if (chat != null && flag == true) {
					text = new ChatVO();
					text.setChatDate(chat[DATE]);
					text.setNickName(chat[NAME]);
					text.setDescription(chat[CHAT]);

					if (checkCount) {
						int lastindex = chatList.size() - 1;
						chatList.remove(lastindex);
					}
					chatList.add(text);
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 못 찾음");
		} catch (NoSuchElementException e) {
			System.out.println("다음 읽을 것을 못찾음");
		} catch (ArrayIndexOutOfBoundsException aiob) {
			System.out.println("입력 불가");
		} catch (IOException e) {
			System.out.println("파일을 못 찾음");
		} finally {

			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return chatList;
	}
}