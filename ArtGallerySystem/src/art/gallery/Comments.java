package art.gallery;

import java.util.ArrayList;

public abstract class Comments {
	ArrayList<Integer> commentId = new ArrayList<Integer>();
	ArrayList<String> commentComments = new ArrayList<String>();
	public void clearComments(){
		this.commentComments.clear();
		this.commentId.clear();
	}
	public ArrayList<Integer> getCommentArtId() {
		return commentId;
	}
	public void setCommentArtId(int commentArtId) {
		this.commentId.add(commentArtId);
	}
	public ArrayList<String> getCommentComments() {
		return commentComments;
	}
	public void setCommentComments(String commentComments) {
		this.commentComments.add(commentComments);
	}
}
