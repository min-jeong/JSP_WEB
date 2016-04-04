package com.ktds.pingpong.chat.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.pingpong.chat.biz.ChatBiz;
import com.ktds.pingpong.chat.vo.ChatRate;

/**
 * Servlet implementation class PropertyByMember
 */
public class PropertyByMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ChatBiz chatbiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropertyByMember() {
        super();
        chatbiz = new ChatBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// team 아이디 받아와야한다.
		int teamId = 4; 
		List<ChatRate> memChatRates = chatbiz.getChatRateByTeamId(teamId);
		List<ChatRate> chatTimeCounts = chatbiz.getTimeChatCountByTeamId(teamId);
		List<ChatRate> firstChatCounts = chatbiz.getFirstChatCountByTeamId(teamId);
		List<ChatRate> fastReplyChatCounts = chatbiz.getFastReplyChatCountByTeamId(teamId);
		List<ChatRate> howManyChatCounts = chatbiz.getHowManyChatByTeamId(teamId);
		List<ChatRate> smileChatCounts = chatbiz.getSmileChatByTeamId(teamId);
		List<ChatRate> angryChatCounts = chatbiz.getAngryChatByTeamId(teamId);
		List<ChatRate> dayChatCounts = chatbiz.getDayChatByTeamId(teamId);
		
		/*System.out.println("ChatRateSize"+memChatRates.size());		*/
		if(memChatRates != null){
		//	System.out.println("ChatRateSize");
			request.setAttribute("memChatRates", memChatRates);
		}
		if(chatTimeCounts != null){
			System.out.println("-------------------------------------------------");
			for(int i = 0 ; i < chatTimeCounts.size() ; i++){
				System.out.println(chatTimeCounts.get(i).getNickName());
				System.out.println(chatTimeCounts.get(i).getMorningChatCount());
				System.out.println(chatTimeCounts.get(i).getNightChatCount());
			}
		}
		if(firstChatCounts != null){
			System.out.println("-------------------------------------------------");
			for(int i = 0 ; i < firstChatCounts.size() ; i++){
				System.out.println(firstChatCounts.get(i).getNickName());
				System.out.println(firstChatCounts.get(i).getFirstChatCount());
				System.out.println(firstChatCounts.get(i).getSumFirstChatCount());
				
			}
		}
		
			
			if(fastReplyChatCounts != null){
				System.out.println("-------------------------------------------------");
				for(int i = 0 ; i < fastReplyChatCounts.size() ; i++){
					System.out.println(fastReplyChatCounts.get(i).getNickName());
					System.out.println(fastReplyChatCounts.get(i).getFirstReplyCountTalk());
					System.out.println(fastReplyChatCounts.get(i).getFirstReplySumTalk());
					System.out.println(fastReplyChatCounts.get(i).getFirstReplyAvgTalk());
				}
			}
			
			if(howManyChatCounts != null){
				System.out.println("-------------------------------------------------");
				for(int i = 0 ; i < howManyChatCounts.size() ; i++){
					System.out.println(howManyChatCounts.get(i).getNickName());
					System.out.println(howManyChatCounts.get(i).getHowManySumText());
					System.out.println(howManyChatCounts.get(i).getHowManyAvgText());
					System.out.println(howManyChatCounts.get(i).getHowMnayTotalCount());
				}
			}
		
			if(smileChatCounts != null){
				System.out.println("-------------------------------------------------");
				for(int i = 0 ; i < smileChatCounts.size() ; i++){
					System.out.println(smileChatCounts.get(i).getNickName());
					System.out.println(smileChatCounts.get(i).getSmileChatCount());
					System.out.println(smileChatCounts.get(i).getSmileSumChatCount());
				}
			}
			
			if(angryChatCounts != null){
				System.out.println("-------------------------------------------------");
				for(int i = 0 ; i < angryChatCounts.size() ; i++){
					System.out.println(angryChatCounts.get(i).getNickName());
					System.out.println(angryChatCounts.get(i).getAngryChatCount());
					System.out.println(angryChatCounts.get(i).getAngrySumChatCount());
				}
			}
			
			if(dayChatCounts != null){
				System.out.println("-------------------------------------------------");
				for(int i = 0 ; i < dayChatCounts.size() ; i++){
					System.out.println(dayChatCounts.get(i).getNickName());
					System.out.println(dayChatCounts.get(i).getDayChatCount());
					System.out.println(dayChatCounts.get(i).getChatDay());
					System.out.println(dayChatCounts.get(i).getDaySumChatCount());
				}
			}
		
		
	     
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/tab/property_mem.jsp");
		rd.forward(request, response);
	}
}

