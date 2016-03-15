package com.ktds.jmj.reply.biz;

import com.ktds.jmj.reply.dao.ReplyDAO;
import com.ktds.jmj.reply.vo.ReplyVO;

public class ReplyBiz {
	
	private ReplyDAO replyDAO;
	
	public ReplyBiz() {
		replyDAO = new ReplyDAO();
	}
	
	public boolean addNewReplyDepthZero(ReplyVO reply){
//		일반 댓글과 첫 번째 대댓글을 달 때
//		depth  부모 글의 depth+1
//		order_no 부모글의 order_no + 1
//		
//		존재하는 대댓글을 달 때
//		depth 부모글의 depth+1
//		order_no 현재 parentReplyId 값의 max+1
		
		int orderNo = this.getNewOrderNo(reply);
		reply.setOrderNo(orderNo);
		
		if( orderNo > 0 ) {
			replyDAO.updateOrderNoByGroupId(reply);
		}
		
		return replyDAO.insertReply(reply) > 0;
			
	}
	
	private int getNewOrderNo ( ReplyVO reply) {
		if (replyDAO.selectCountParentReplyID(reply) > 0) {
			int newOrderNo = replyDAO.selectMaxOrderNoByParentReplyID(reply);
			return newOrderNo + 1;			
		}
		else {
			if( reply.getParentReplyId() != 0 ) {
				int newOrderNo = replyDAO.selectLatestOrderNoByParentReplyID(reply);
				return newOrderNo + 1;
			}
		}		
		return 0; // 일반 댓글일 때
	}
}
