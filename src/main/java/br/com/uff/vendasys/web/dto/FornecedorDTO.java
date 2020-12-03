package br.com.uff.vendasys.web.dto;

public class FornecedorDTO {
    private String cnpj;
    private String cnpjFormatado;
    private String razaoSocial;
    private EnderecoDTO endereco;

    public FornecedorDTO() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpjFormatado() {
        return cnpjFormatado;
    }

    public void setCnpjFormatado(String cnpjFormatado) {
        this.cnpjFormatado = cnpjFormatado;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }
}
