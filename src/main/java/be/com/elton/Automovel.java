package be.com.elton;

import javax.faces.convert.FacesConverter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import be.com.elton.validation.groups.ValidacaoMinima;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Entity
@Table(name = "automovel")
@FacesConverter("automovel")
public class Automovel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private Modelo modelo;
    @Min(1900)
    @Max(message = "O maximo do ano da fabricaçao é: ", value = 0)
	private Integer anoFabricacao;
    @Min(1900)
    @Max(value = 1, message = "O maximo do ano do modelo é {0}")
	private Integer anoModelo;
    @NotNull(groups = {ValidacaoMinima.class, Default.class})
	private Double preco;
	private Double kilometragem;
	private String observacoes;

	public Automovel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

}
