package com.consumer;

import java.util.List;

public class PostOffsetsRequestDTO {
	private List<PostOffsetDTO> offsets;

	public List<PostOffsetDTO> getOffsets() {
		return offsets;
	}

	public void setOffsets(List<PostOffsetDTO> postOffsetDTO) {
		this.offsets = postOffsetDTO;
	}
	
}
