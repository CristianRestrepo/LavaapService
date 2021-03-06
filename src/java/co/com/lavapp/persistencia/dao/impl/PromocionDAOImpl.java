/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao.impl;

import co.com.lavapp.conexion.ConexionSQL;
import co.com.lavapp.modelo.dto.Promocion_TO;
import co.com.lavapp.persistencia.dao.PromocionDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author VaioDevelopment
 */
public class PromocionDAOImpl implements PromocionDAO {

    private final Statement st = ConexionSQL.conexion();

    @Override
    public List<Promocion_TO> consultarPromociones() throws Exception {
        List<Promocion_TO> promociones = new ArrayList<>();
        try {
            try {
                String sql = "SELECT idpromocion, fechainicio, fechafinal, porcentaje, horainicio, horafinal, nombre "
                        + " FROM  public.promocion";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    promociones.add(new Promocion_TO(rs.getInt(1),
                            rs.getDate(2),
                            rs.getDate(3),
                            rs.getInt(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7)));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return promociones;
    }

    @Override
    public Promocion_TO consultarPromocion(Promocion_TO promocion) throws Exception {
        Promocion_TO nuevaPromocion = new Promocion_TO();
        try {
            try {
                String sql = "SELECT idpromocion, fechainicio, fechafinal, porcentaje, horainicio, horafinal, nombre "
                        + " FROM  public.promocion WHERE idpromocion = '" + promocion.getIdPromocion() + "' or nombre = '" + promocion.getNombre() + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    nuevaPromocion = new Promocion_TO(rs.getInt(1),
                            rs.getDate(2),
                            rs.getDate(3),
                            rs.getInt(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevaPromocion;
    }

    @Override
    public Promocion_TO registrarPromocion(Promocion_TO promocion) throws Exception {
        Promocion_TO p = new Promocion_TO();
        try {
            try {
                String sql = "INSERT INTO public.promocion (fechainicio, fechafinal, porcentaje, horainicio, horafinal, nombre) "
                        + " values("
                        + " '" + promocion.getFechaInicio() + "',"
                        + " '" + promocion.getFechaFinal() + "',"
                        + " " + promocion.getPorcentaje() + ","
                        + " '" + promocion.getHoraInicio() + "',"
                        + " '" + promocion.getHorafinal() + "',"
                        + " '" + promocion.getNombre() + "')";
                st.execute(sql);
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return p;
    }

    @Override
    public Promocion_TO modificarPromocion(Promocion_TO promocion) throws Exception {
        Promocion_TO p = new Promocion_TO();
        try {
            try {
                String sql = "UPDATE public.promocion SET "
                        + " fechainicio = '" + promocion.getFechaInicio() + "',"
                        + " fechafinal = '" + promocion.getFechaFinal() + "',"
                        + " porcentaje = '" + promocion.getPorcentaje() + "',"
                        + " horainicio = '" + promocion.getHoraInicio() + "',"
                        + " horafinal = '" + promocion.getHorafinal() + "',"
                        + " nombre = '" + promocion.getNombre() + "' "
                        + " WHERE idpromocion = '" + promocion.getIdPromocion() + "'";

                st.execute(sql);
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return p;
    }

    @Override
    public Promocion_TO eliminarPromocion(Promocion_TO promocion) throws Exception {
        Promocion_TO p = new Promocion_TO();
        try {
            try {
                String sql = "DELETE FROM public.promocion WHERE idpromocion = '" + promocion.getIdPromocion() + "'";
                st.execute(sql);
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return p;
    }

    @Override
    public Promocion_TO consultarPromocionActiva() throws Exception {
        Promocion_TO nuevaPromocion = new Promocion_TO();
        Date fechaActual = new Date();
        SimpleDateFormat sdft = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            try {
                String sql = "SELECT idpromocion, fechainicio, fechafinal, porcentaje, horainicio, horafinal, nombre"
                        + " FROM  public.promocion"
                        + " WHERE"
                        + " fechainicio < '" + sdf.format(fechaActual) + "' and fechafinal >  '" + sdf.format(fechaActual) + "' and fechainicio <> fechafinal"
                        + " OR fechainicio = '" + sdf.format(fechaActual) + "' and fechafinal >  '" + sdf.format(fechaActual) + "' and fechainicio <> fechafinal"
                        + " AND horainicio <= '" + sdft.format(fechaActual) + "'"
                        + " OR fechainicio < '" + sdf.format(fechaActual) + "' and fechafinal =  '" + sdf.format(fechaActual) + "' and fechainicio <> fechafinal"
                        + " AND horafinal > '" + sdft.format(fechaActual) + "'"
                        + " OR fechainicio = '" + sdf.format(fechaActual) + "' and fechainicio = fechafinal"
                        + " AND horainicio <= '" + sdft.format(fechaActual) + "' AND horafinal > '" + sdft.format(fechaActual) + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    nuevaPromocion = new Promocion_TO(rs.getInt(1),
                            rs.getDate(2),
                            rs.getDate(3),
                            rs.getInt(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7));
                }
            } catch (SQLException e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ConexionSQL.CerrarConexion();
        }
        return nuevaPromocion;
    }

}
