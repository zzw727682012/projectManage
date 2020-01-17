package com.consumer.releaseorder;

public class ReleaseOrderNoteDTO {
	private Long displaySequence;
	private Boolean isVisible;
	private Long noteId;
	private String noteText;
	private String noteType;
	public Long getDisplaySequence() {
		return displaySequence;
	}
	public void setDisplaySequence(Long displaySequence) {
		this.displaySequence = displaySequence;
	}
	public Boolean getIsVisible() {
		return isVisible;
	}
	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	}
	public Long getNoteId() {
		return noteId;
	}
	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}
	public String getNoteText() {
		return noteText;
	}
	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}
	public String getNoteType() {
		return noteType;
	}
	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}
	
}
