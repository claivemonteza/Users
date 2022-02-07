package com.example.demo.access.service.wrapper;

import java.util.List;

import com.example.demo.access.dto.ResultSaveDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class ListWrapper<T> {
	
	private List<ResultSaveDTO> resultList;
	private int listSize;
	
	public Boolean isAllSaved() {
		int count = 0;
		for(int i = 0; i < this.resultList.size(); i++) {
			if(this.resultList.get(i).getIntegrated() == true) {
				count = count + 1;
			}
		}
		return (count > 0 && count == this.listSize);
	}

}
