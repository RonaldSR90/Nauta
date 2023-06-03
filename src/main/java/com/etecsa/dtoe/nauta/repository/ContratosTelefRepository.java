package com.etecsa.dtoe.nauta.repository;

import com.etecsa.dtoe.nauta.models.entity.ContratosTelef;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
/* En este ejemplo estaba haciendo una consulta directa a la BD
@Repository
public interface ContratosTelefRepository extends JpaRepository<ContratosTelef, String> {

    @Query("SELECT c from ContratosTelef c where c.servicio = ?1")
    public List<ContratosTelef> findAllByServicio(@Param("servicio") String servicio);

    @Query("SELECT c from ContratosTelef c where c.solicitado = ?1")
    public List<ContratosTelef> findAllBySolicitado(@Param("solicitado") String solicitado);
}


 */

@Repository
public interface ContratosTelefRepository extends JpaRepository<ContratosTelef, Long> {

 //   void deleteByServicio(String servicio);

    ContratosTelef findByServicio(String servicio);

    ContratosTelef findBySolicitado(String solicitado);

    List<ContratosTelef> findAll(Sort sort);

    Page<ContratosTelef> findBySolicitado(String solicitado, Pageable pageable);

    Page<ContratosTelef> findBySolicitadoIsNotNull(Pageable pageable);

    Page<ContratosTelef> findByServicio(String servicio, Pageable pageable);

   // @Query("SELECT c FROM ContratosTelef c WHERE c.nombpta = :nombpta AND c.sitio = :sitio")
    Page<ContratosTelef> findByNombptaAndSitio(@Param("planta") String nombpta, @Param("sitio") String sitio, Pageable pageable);


    //para hacer la lista de la busqueda por solicitado
    @Query("SELECT DISTINCT solicitado FROM ContratosTelef ORDER BY solicitado")
    List<String> findDistinctSolicitado();

    //lista desplegable para la busqueda por planta y stio
    @Query("SELECT DISTINCT nombpta FROM ContratosTelef ORDER BY nombpta")
    List<String> findPlanta();

    @Query("SELECT DISTINCT sitio FROM ContratosTelef ORDER BY sitio")
    List<String> findSitio();


}
