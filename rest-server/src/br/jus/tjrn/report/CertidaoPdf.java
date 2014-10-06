package br.jus.tjrn.report;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import br.jus.tjrn.dto.EscolhaCertidaoDto;

public class CertidaoPdf extends Html2Pdf {
	
	private String codigoValidacao;
	private EscolhaCertidaoDto escolhaCertidaoDto;
	private List<Object[]> listaProcessos;
	
	public CertidaoPdf(BigInteger codigoValidacao, Object escolhaCertidaoDto, List<Object[]> listaProcessos) {
		this.codigoValidacao = codigoValidacao.toString();
		this.escolhaCertidaoDto = (EscolhaCertidaoDto) escolhaCertidaoDto;
		this.listaProcessos = listaProcessos;
	}

	@Override
	public HashMap<String, Object> getContent() {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put( "codigoValidacao",  String.format("%010d", new Integer(codigoValidacao)) );
		hash.put( "nome",  escolhaCertidaoDto.getNome().toUpperCase() );
		hash.put( "nomeCpfCnpj",  escolhaCertidaoDto.getCpfCnpj().length() > 14 ? "CNPJ" : "CPF" );
		hash.put( "cpfCnpj",  escolhaCertidaoDto.getCpfCnpj() );
        hash.put( "listaProcessos",  listaProcessos );
        hash.put( "tipoCertidao", escolhaCertidaoDto.getTipoCertidao().getNome() );
        
        DateFormat dfmt = new SimpleDateFormat("EEEE', 'd' de 'MMMM' de 'yyyy' às 'HH'h'mm'm'.");
        Date hoje = Calendar.getInstance(Locale.getDefault()).getTime();
        hash.put( "dataAtualExtenso",  dfmt.format(hoje).toLowerCase() );
		
		return hash;
	}

}