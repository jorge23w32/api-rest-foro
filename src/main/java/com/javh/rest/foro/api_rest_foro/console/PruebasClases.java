//package com.javh.rest.foro.api_rest_foro.console;
//
//import com.javh.rest.foro.api_rest_foro.domain.topico.DatosTopico;
//import com.javh.rest.foro.api_rest_foro.domain.topico.Topico;
//import com.javh.rest.foro.api_rest_foro.domain.topico.TopicoRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//public class PruebasClases {
//    private TopicoRepository topicoRepository;
//    public PruebasClases(TopicoRepository topicoRepository){
//        this.topicoRepository = topicoRepository;
//    }
//    public void probar(){
//        Long i = 1L;
//        var  topico = topicoRepository.findById(1L);
//        if(topico.isPresent()){
//            System.out.println(topico.get().getId());
//        }
//
//
//
//    }
//}
