package com.ktds.pingpong.chat.biz;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ktds.pingpong.chat.dao.ChatDAO;
import com.ktds.pingpong.chat.vo.ChatRate;
import com.ktds.pingpong.chat.vo.ChatVO;
import com.ktds.pingpong.member.vo.MemberVO;
import com.ktds.pingpong.team.vo.TeamVO;
import com.ktds.pingpong.util.SplitTextFile;

public class ChatBiz {

	private ChatDAO chatDAO;

	public ChatBiz() {
		chatDAO = new ChatDAO();
	}

	public List<String> getMemberByTeamId(int teamId) {
		List<String> memberList = chatDAO.getAllMember(teamId);

		return memberList;
	}

	public boolean insertChatText(File upFile, HttpServletRequest request) {
		SplitTextFile split = new SplitTextFile();
		List<ChatVO> chatList = split.splitTextFile(upFile);

		HttpSession session = request.getSession();
		TeamVO loginTeam = (TeamVO) session.getAttribute("_TEAM_");

		int teamId = loginTeam.getTeamId();

		chatDAO.deleteAllChatByTeamId(teamId);
		System.out.println("chatList Size = " + chatList.size());
		int insertCount = chatDAO.insertChatText(chatList, teamId);

		if (insertCount > 0) {
			return true;
		} else {
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
		List<ChatRate> angryChatCounts = chatDAO.getAngryChatByTeamId(teamId);
		return angryChatCounts;
	}

	public List<ChatRate> getDayChatByTeamId(int teamId) {
		List<ChatRate> dayChatCounts = chatDAO.getDayChatByTeamId(teamId);
		return dayChatCounts;
	}

}