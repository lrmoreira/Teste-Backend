package br.com.lucas.jdbc;

public class Contatos {

	String[] pessoas = {"Rodrigo","Claudio","Romario","Juliene","Vanessa","David","Leandro","Beatriz","Rosangela","Jevan","Andre","Miriam","Pedro","Tiago","Joao","Fernando","Osni"};
	String[] cpf_cnpj = {"826.916.283-37","391.678.838-85","920.121.621-18","679.221.574-01","763.386.388-95","184.053.365-08", "184.053.365-08", "652.485.568-05", "598.008.015-53", "221.547.604-49", "747.417.651-30", "636.307.722-26", "636.381.074-42", "337.290.408-71","875.887.240-05", "010.415.703-84", "199.934.518-51"};
	
	public String getPessoas(int vetor) {
		return this.pessoas[vetor];
	}
	public void setPessoas(String nomePessoa, int vetor) {
		this.pessoas[vetor] = nomePessoa;
	}
	public String getCpf_cnpj(int vetor) {
		return cpf_cnpj[vetor];
	}
	public void setCpf_cnpj(String cpf_cnpj, int vetor) {
		this.cpf_cnpj[vetor] = cpf_cnpj;
	}
	

}
