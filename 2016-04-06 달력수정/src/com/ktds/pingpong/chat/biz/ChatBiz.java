package com.ktds.pingpong.chat.biz;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ktds.pingpong.calendar.dao.CalendarDAO;
import com.ktds.pingpong.chat.dao.ChatDAO;
import com.ktds.pingpong.chat.vo.ChatRate;
import com.ktds.pingpong.chat.vo.ChatVO;
import com.ktds.pingpong.member.vo.MemberVO;
import com.ktds.pingpong.team.vo.TeamVO;
import com.ktds.pingpong.util.SplitTextFile;

public class ChatBiz {

	private ChatDAO chatDAO;
	private CalendarDAO calendarDAO;

	public ChatBiz() {
		chatDAO = new ChatDAO();
		calendarDAO = new CalendarDAO();
	}

	public List<String> getMemberByTeamId(int teamId) {
		List<String> memberList = chatDAO.getAllMember(teamId);

		return memberList;
	}

	public boolean insertChatText(File upFile, HttpServletRequest request) {
		// 텍스트를 분류한다.
		SplitTextFile split = new SplitTextFile();
		List<ChatVO> chatList = split.splitTextFile(upFile);
		
		HttpSession session = request.getSession();
		TeamVO loginTeam = (TeamVO) session.getAttribute("_TEAM_");
		MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");

		int teamId = loginTeam.getTeamId();
		
		// TeamId를 받아오면 모든 공지와 챗을 삭제시켜준다.
		{
		calendarDAO.removeByCalendarId(teamId);
		chatDAO.deleteAllChatByTeamId(teamId);
		}
		
		// 공지를 추출한다.
		if(chatList.size()!=0){ 
			List<ChatVO> noticeList = split.splitNotices(chatList);
			System.out.println("공지사이즈 "+noticeList.size());
			calendarDAO.insertNoticesbyChatVO(noticeList, teamId);
		}
		
		System.out.println("chatList Size = " + chatList.size());
		int insertCount = chatDAO.insertChatText(chatList, teamId);

		if (insertCount > 0) {
			int updateCount = chatDAO.updateTeamInfoChatUpdate(loginMember.getName(), loginTeam.getTeamId());
			
			if ( updateCount > 0 ) {
				return true;
			}
			else {
				return false;
			}
		} 
		
		else {
			return false;
		}

	}

	public List<ChatVO> getAllChatByNickName(String nickName, int teamId) {
		List<ChatVO> chatList = chatDAO.getAllChatByNickName(nickName, teamId);
		return chatList;
	}

	public List<ChatVO> getAllChatByDay(String selectDay, int teamId) {
		List<ChatVO> chatList = chatDAO.getAllChatByDay(selectDay, teamId);
		return chatList;
	}

	public List<ChatRate> getChatRateByTeamId(int teamId) {
		List<ChatRate> chatRates = chatDAO.getChatRateByTeamId(teamId);
		return chatRates;
	}

	public List<ChatRate> getTimeChatCountByTeamId(int teamId) {
		List<ChatRate> chatTimeCounts = chatDAO.getTimeChatCountByTeamId(teamId);
		return chatTimeCounts;
	}

	public List<ChatRate> getFirstChatCountByTeamId(int teamId) {
		List<ChatRate> firstChatCounts = chatDAO.getFirstChatCountByTeamId(teamId);
		return firstChatCounts;
	}

	public List<ChatRate> getFastReplyChatCountByTeamId(int teamId) {
		List<ChatRate> fastReplyChatCounts = chatDAO.getFastReplyChatCountByTeamId(teamId);
		return fastReplyChatCounts;
	}

	public List<ChatRate> getHowManyChatByTeamId(int teamId) {
		List<ChatRate> howManyChatCounts = chatDAO.getHowManyChatByTeamId(teamId);
		return howManyChatCounts;
	}

	public List<ChatRate> getSmileChatByTeamId(int teamId) {
		List<ChatRate> smileChatCounts = chatDAO.getSmileChatByTeamId(teamId);
		return smileChatCounts;
	}

	public List<ChatRate> getAngryChatByTeamId(int teamId) {
		System.out.println("ChatBiz의 getAngryChatByTeamId 실행");
		
		List<ChatRate> angryChatCounts = chatDAO.getAngryChatByTeamId(teamId);
		return angryChatCounts;
	}

	public List<ChatRate> getDayChatByTeamId(int teamId) {
		System.out.println("ChatBiz의 getDayChatByTeamId 실행");
		List<ChatRate> dayChatCounts = chatDAO.getDayChatByTeamId(teamId);
		return dayChatCounts;
	}
	
	public List<ChatVO> getChatByKeyword(String keyword, int teamId) {
		System.out.println("ChatBiz의 getChatByKeyword 실행");
		int updateCount = 0;
		int insertCount = 0;
		List<ChatVO> chatList = chatDAO.getNearChatByKeyword(keyword, teamId);
		
		List<String> keyList = chatDAO.getKeywordByTeamId(teamId);
		
		if ( keyList.contains(keyword) ) {
			updateCount = chatDAO.updateKeywordInDB(keyword, teamId);
		}
		else if ( !keyList.contains(keyword)) {
			insertCount = chatDAO.insertKeywordIntoDB(keyword, teamId);
		}
		
		if ( insertCount > 0 || updateCount > 0 ) {
			return chatList;
		}
		else return null;
	
	}

	public List<String> getKeywordByTeamId(int teamId) {
		System.out.println("ChatBiz의 getKeywordByTeamId 실행");
		List<String> keywords = chatDAO.getKeywordByTeamId(teamId);
		for (String key : keywords) {
			System.out.println("DB에서 가져온 키는 "+key);
		}
		return keywords;
	}


}