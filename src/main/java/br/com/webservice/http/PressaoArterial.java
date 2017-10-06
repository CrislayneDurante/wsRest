package br.com.webservice.http;

public class PressaoArterial {
	
	private float pressaoAltaMedia;
	private float pressaBaixaMedia;
	
	public PressaoArterial() {
	
	}

	public PressaoArterial(float pressaoAltaMedia, float pressaBaixaMedia) {
		this.pressaoAltaMedia = pressaoAltaMedia;
		this.pressaBaixaMedia = pressaBaixaMedia;
	}

	public float getPressaoAltaMedia() {
		return pressaoAltaMedia;
	}

	public void setPressaoAltaMedia(float pressaoAltaMedia) {
		this.pressaoAltaMedia = pressaoAltaMedia;
	}

	public float getPressaBaixaMedia() {
		return pressaBaixaMedia;
	}

	public void setPressaBaixaMedia(float pressaBaixaMedia) {
		this.pressaBaixaMedia = pressaBaixaMedia;
	}
	
	

}//Fim da classe PressaoArterial
