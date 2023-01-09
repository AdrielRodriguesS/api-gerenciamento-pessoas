package br.com.gerenciamentopessoas.api.configuration.validation;

import java.time.LocalDate;

public class MensagemErro {
	
	private LocalDate dataDoErro;
	private Integer status;
	private String mensagem;
	
	public MensagemErro(LocalDate dataDoErro, Integer status, String mensagem) {
		this.dataDoErro = dataDoErro;
		this.status = status;
		this.mensagem = mensagem;
	}

	public LocalDate getDataDoErro() {
		return dataDoErro;
	}

	public void setDataDoErro(LocalDate dataDoErro) {
		this.dataDoErro = dataDoErro;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
