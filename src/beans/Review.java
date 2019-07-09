package beans;

public class Review {
	private int reviewId;
	private int userId;
	private String reviewText;
	
	public Review(int reviewId, int userId, String reviewText){
		this.reviewId = reviewId;
		this.userId = userId;
		this.reviewText = reviewText;
	}
	
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
}
