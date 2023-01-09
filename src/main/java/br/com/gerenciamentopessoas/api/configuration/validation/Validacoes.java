package br.com.gerenciamentopessoas.api.configuration.validation;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.UnexpectedTypeException;

@ControllerAdvice
public class Validacoes {
	
	@RestControllerAdvice
	public class validacaoDeExcecoes {
		
		@ResponseBody
		@ExceptionHandler(NoSuchElementException.class)
		public ResponseEntity<MensagemErro> pathError(NoSuchElementException exception){
			MensagemErro errorMessage = new MensagemErro(
					LocalDate.now(), HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.getReasonPhrase());
			return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
		}
		
		@ResponseBody
		@ExceptionHandler(NumberFormatException.class)
		public ResponseEntity<MensagemErro> pathError(NumberFormatException exception){
			MensagemErro errorMessage = new MensagemErro(
					LocalDate.now(), HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.getReasonPhrase());
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		
		@ResponseBody
		@ExceptionHandler(UnexpectedTypeException.class)
		public ResponseEntity<MensagemErro> pathError(UnexpectedTypeException exception){
			MensagemErro errorMessage = new MensagemErro(
					LocalDate.now(), HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.getReasonPhrase());
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		
		@ResponseBody
		@ExceptionHandler(HttpMessageNotReadableException.class)
		public ResponseEntity<MensagemErro> pathError(HttpMessageNotReadableException exception){
			MensagemErro errorMessage = new MensagemErro(
					LocalDate.now(), HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.getReasonPhrase());
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		
		@ResponseBody
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<MensagemErro> pathError(MethodArgumentNotValidException exception){
			MensagemErro errorMessage = new MensagemErro(
					LocalDate.now(), HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.getReasonPhrase());
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		
		@ResponseBody
		@ExceptionHandler(NullPointerException.class)
		public ResponseEntity<MensagemErro> pathError(NullPointerException exception){
			MensagemErro errorMessage = new MensagemErro(
					LocalDate.now(), HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.getReasonPhrase());
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		
	}

}
