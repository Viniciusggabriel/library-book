package com.library.infra.database.repositories.finders;

import io.ebean.Finder;
import io.ebean.PagedList;

public class EntityFinder<ID, T> extends Finder<ID, T> {
    public EntityFinder(Class<T> type) {
        super(type);
    }

    /**
     * <h3>Método da classe Finder para poder fazer um select paginado </h3>
     * <p>Realiza o select dentro do banco de dados de forma organizada pelo atributo passado, como exemplo o nome do entidade</p>
     *
     * @param atributeBook -> <strong>Atributo da classe de entidade a ser ordenada</strong>
     * @param size         -> <strong>Tamanho de linhas a ser requisitados</strong>
     * @return PagedList<T> -> <strong>Retorna um SQL paginado</strong>
     */
    public PagedList<T> findAll(String atributeBook, Integer size) {
        return query().where().orderBy().asc(atributeBook).setMaxRows(size).findPagedList();
    }

    /**
     * <h3>Método par abuscar um entidade baseado no nome</h3>
     *
     * @param atribute -> <strong>Atributo da classe de entidade a ser ordenada</strong>
     * @param name     -> <strong>Nome do entidade a ser buscado</strong>
     * @return T -> <strong>Entidade encontrado</strong>
     */
    public T byName(String atribute, String name) {
        return query().where().eq(atribute, name).findOne();
    }
}
