package br.com.codenation;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.entities.Jogador;
import br.com.codenation.entities.Time;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.codenation.constantes.MENSAGENS_JOGADOR;
import static br.com.codenation.constantes.MENSAGENS_TIME;
import static br.com.codenation.constantes.MENSAGENS_GERAL;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

    private List<Time> timesEmMemoria = new ArrayList<>();
    private List<Jogador> jogadoresEmMemoria = new ArrayList<>();

    @Desafio("incluirTime")
    public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        verificarIdentificador(id);
        timesEmMemoria.add(new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
    }

    @Desafio("incluirJogador")
    public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        verificarIdentificador(id);
        buscarTimePorId(idTime);
        jogadoresEmMemoria.add(new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario));
    }

    @Desafio("definirCapitao")
    public void definirCapitao(Long idJogador) {
        Jogador jogador = buscarJogadorPorId(idJogador);
        buscarTimePorId(jogador.getIdTime()).
                setIdCapitao(jogador.getId());
    }

    @Desafio("buscarCapitaoDoTime")
    public Long buscarCapitaoDoTime(Long idTime) {
        Time time = buscarTimePorId(idTime);

        if (time.getIdCapitao() == null)
            throw new CapitaoNaoInformadoException();

        return time.getIdCapitao();
    }

    @Desafio("buscarNomeJogador")
    public String buscarNomeJogador(Long idJogador) {
        return buscarJogadorPorId(idJogador).getNome();
    }

    @Desafio("buscarNomeTime")
    public String buscarNomeTime(Long idTime) {
        return buscarTimePorId(idTime).getNome();
    }

    @Desafio("buscarJogadoresDoTime")
    public List<Long> buscarJogadoresDoTime(Long idTime) {
        buscarTimePorId(idTime);

        return jogadoresEmMemoria.stream()
                .sorted(Comparator.comparingLong(Jogador::getId))
                .filter(jogador -> jogador.getIdTime().equals(idTime))
                .map(Jogador::getId)
                .collect(Collectors.toList());
    }

    @Desafio("buscarMelhorJogadorDoTime")
    public Long buscarMelhorJogadorDoTime(Long idTime) {
        return jogadoresEmMemoria.stream()
                .filter(jogador -> jogador.getIdTime().equals(idTime))
                .max(Comparator.comparing(Jogador::getNivelHabilidade))
                .map(Jogador::getId)
                .orElseThrow(() -> new TimeNaoEncontradoException(MENSAGENS_TIME.NAO_ENCONTRADO));
    }

    @Desafio("buscarJogadorMaisVelho")
    public Long buscarJogadorMaisVelho(Long idTime) {
        return jogadoresEmMemoria.stream()
                .filter(jogador -> jogador.getIdTime().equals(idTime))
                .min(Comparator.comparing(Jogador::getDataNascimento))
                .map(Jogador::getId)
                .orElseThrow(() -> new TimeNaoEncontradoException(MENSAGENS_TIME.NAO_ENCONTRADO));
    }

    @Desafio("buscarTimes")
    public List<Long> buscarTimes() {
        return timesEmMemoria.stream()
                .sorted(Comparator.comparingLong(Time::getId))
                .map(Time::getId)
                .collect(Collectors.toList());
    }

    @Desafio("buscarJogadorMaiorSalario")
    public Long buscarJogadorMaiorSalario(Long idTime) {
        return jogadoresEmMemoria.stream()
                .sorted(Comparator
                        .comparing(Jogador::getSalario).reversed()
                        .thenComparingLong(Jogador::getId))
                .filter(jogador -> jogador.getIdTime().equals(idTime))
                .map(Jogador::getId).findFirst()
                .orElseThrow(() -> new TimeNaoEncontradoException(MENSAGENS_TIME.NAO_ENCONTRADO));
    }

    @Desafio("buscarSalarioDoJogador")
    public BigDecimal buscarSalarioDoJogador(Long idJogador) {
        return buscarJogadorPorId(idJogador).getSalario();
    }

    @Desafio("buscarTopJogadores")
    public List<Long> buscarTopJogadores(Integer top) {
        return jogadoresEmMemoria.stream()
                .sorted(Comparator
                        .comparingInt(Jogador::getNivelHabilidade).reversed()
                        .thenComparingLong(Jogador::getId))
                .limit(top)
                .map(Jogador::getId)
                .collect(Collectors.toList());
    }

    @Desafio("buscarCorCamisaTimeDeFora")
    public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {

        Time _timeDaCasa = buscarTimePorId(timeDaCasa);
        Time _timeDeFora = buscarTimePorId(timeDeFora);

        if (_timeDaCasa.getCorUniformePrincipal().equals(_timeDeFora.getCorUniformePrincipal()))
            return _timeDeFora.getCorUniformeSecundario();

        return _timeDeFora.getCorUniformePrincipal();

    }

    private Time buscarTimePorId(Long idTime) {
        return timesEmMemoria.stream().filter(time -> time.getId().equals(idTime))
                .findFirst()
                .orElseThrow(() -> new TimeNaoEncontradoException(MENSAGENS_TIME.NAO_ENCONTRADO));
    }

    private Jogador buscarJogadorPorId(Long idJogador) {
        return jogadoresEmMemoria.stream().filter(jogador1 -> jogador1.getId().equals(idJogador))
                .findFirst().orElseThrow(() -> new JogadorNaoEncontradoException(MENSAGENS_JOGADOR.NAO_ENCONTRADO));
    }

    private boolean verificarIdentificadorJogador(Long id) {
        return jogadoresEmMemoria.stream().anyMatch(jogador -> jogador.getId().equals(id));
    }

    private boolean verificarIdentificadorTime(Long id) {
        return timesEmMemoria.stream().anyMatch(time -> time.getId().equals(id));
    }

    public void verificarIdentificador(Long id) {
        if (verificarIdentificadorTime(id) || verificarIdentificadorJogador(id)) {
            throw new IdentificadorUtilizadoException(MENSAGENS_GERAL.IDENTIFICADOR_INDISPONIVEL);
        }
    }
}