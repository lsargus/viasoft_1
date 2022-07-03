package com.argus.viasoft.teste_1.schedulingtasks;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.argus.viasoft.teste_1.enums.FazendaAutorizador;
import com.argus.viasoft.teste_1.enums.StatusCheckFazenda;
import com.argus.viasoft.teste_1.enums.StatusDisponibilidadeFazenda;
import com.argus.viasoft.teste_1.models.CheckFazenda;
import com.argus.viasoft.teste_1.models.CheckFazendaItens;
import com.argus.viasoft.teste_1.servervices.CheckFazendaService;

@Component
public class TaskServerStatus {

	@Autowired
	private CheckFazendaService checkFazendaService;


	@Scheduled(cron = "0 */5 * * * *")
	public void checkStatus() {

		var check = new CheckFazenda();
		check.setItens(new ArrayList<>());
		try {
			Document doc = Jsoup.connect("http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx").get();

			Element table = doc.select("table").get(1);

			Elements rows = table.select("tr");

			Iterator<Element> iRows = rows.stream().skip(1L).iterator();// ignora a primeira linha

			while (iRows.hasNext()) {
				Element row = iRows.next();

				var item = new CheckFazendaItens();
				item.getPk().setCheckFazenda(check);

				var i = 0;
				Optional.ofNullable(row.child(i++))
						.ifPresent(v -> item.getPk().setAutorizador(FazendaAutorizador.getFromString(v.text())));

				Elements data = row.child(i++).select("img");
				item.setAutorizacao4(readCellStatus(data));

				data = row.child(i++).select("img");
				item.setRetAutorizacao4(readCellStatus(data));

				data = row.child(i++).select("img");
				item.setInutilizacao4(readCellStatus(data));

				data = row.child(i++).select("img");
				item.setProtocolo4(readCellStatus(data));

				data = row.child(i++).select("img");
				item.setStatusServ4(readCellStatus(data));

				item.setTempo(row.child(i++).text());

				data = row.child(i++).select("img");
				item.setCadastro4(readCellStatus(data));

				data = row.child(i).select("img");
				item.setRecepcaoEvento4(readCellStatus(data));

				check.getItens().add(item);

			}

			check.setStatus(StatusCheckFazenda.OK);
		} catch (IOException e) {
			check.setStatus(StatusCheckFazenda.FAIL);
		}

		check.setDtCheck(LocalDateTime.now());

		checkFazendaService.save(check);

	}

	private StatusDisponibilidadeFazenda readCellStatus(Elements data) {
		if (!data.isEmpty())
			return StatusDisponibilidadeFazenda.getFromImageName(data.get(0).attr("src"));

		return null;
	}

}
