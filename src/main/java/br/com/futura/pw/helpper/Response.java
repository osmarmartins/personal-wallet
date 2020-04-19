package br.com.futura.pw.helpper;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Response<T> {

	private T data;
	private List<String> errors;
	
	
}
