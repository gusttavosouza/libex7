/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     23/04/2020 21:03:51                          */
/*==============================================================*/


drop table if exists ALUNO;

drop table if exists AUTOR;

drop table if exists DEVOLUCAO;

drop table if exists EMPRESTIMO;

drop table if exists EMPRESTIMO_EXEMPLAR;

drop table if exists EXEMPLAR;

drop table if exists OBRA;

drop table if exists OBRA_AUTOR;

drop table if exists SERVIDOR;

drop table if exists SITUACAO_EXEMPLAR;

drop table if exists TELEFONE_USUARIO;

drop table if exists TIPO_OBRA;

drop table if exists USUARIO;

/*==============================================================*/
/* Table: ALUNO                                                 */
/*==============================================================*/
create table ALUNO
(
   CODIGO_USUARIO       int not null auto_increment,
   REGISTRO_ALUNO       bigint,
   primary key (CODIGO_USUARIO)
);

/*==============================================================*/
/* Table: AUTOR                                                 */
/*==============================================================*/
create table AUTOR
(
   CODIGO_AUTOR         int not null auto_increment,
   NOME_AUTOR           varchar(150) not null,
   primary key (CODIGO_AUTOR)
);

/*==============================================================*/
/* Table: DEVOLUCAO                                             */
/*==============================================================*/
create table DEVOLUCAO
(
   DATA_DEVOLUCAO       date not null,
   CODIGO_USUARIO       int not null,
   DATA_EMPRESTIMO      datetime not null,
   primary key (DATA_DEVOLUCAO)
);

/*==============================================================*/
/* Table: EMPRESTIMO                                            */
/*==============================================================*/
create table EMPRESTIMO
(
   CODIGO_USUARIO       int not null,
   DATA_EMPRESTIMO      datetime not null,
   DATA_DEVOLUCAO       date not null,
   DATA_PREVISTA_DEVOLUCAO_EMPRESTIMO datetime not null,
   primary key (CODIGO_USUARIO, DATA_EMPRESTIMO)
);

/*==============================================================*/
/* Table: EMPRESTIMO_EXEMPLAR                                   */
/*==============================================================*/
create table EMPRESTIMO_EXEMPLAR
(
   CODIGO_USUARIO       int not null,
   DATA_EMPRESTIMO      datetime not null,
   CODIGO_EXEMPLAR      int not null,
   primary key (CODIGO_USUARIO, DATA_EMPRESTIMO, CODIGO_EXEMPLAR)
);

/*==============================================================*/
/* Table: EXEMPLAR                                              */
/*==============================================================*/
create table EXEMPLAR
(
   CODIGO_EXEMPLAR      int not null auto_increment,
   CODIGO_SITUACAO_EXEMPLAR int not null,
   CODIGO_OBRA          int not null,
   DATA_AQUISICAO_EXEMPLAR date not null,
   primary key (CODIGO_EXEMPLAR)
);

/*==============================================================*/
/* Table: OBRA                                                  */
/*==============================================================*/
create table OBRA
(
   CODIGO_OBRA          int not null auto_increment,
   CODIGO_TIPO_OBRA     int not null,
   TITULO_OBRA          varchar(250) not null,
   ANO_PUBLICACAO_OBRA  int not null,
   primary key (CODIGO_OBRA)
);

/*==============================================================*/
/* Table: OBRA_AUTOR                                            */
/*==============================================================*/
create table OBRA_AUTOR
(
   CODIGO_AUTOR         int not null,
   CODIGO_OBRA          int not null,
   primary key (CODIGO_AUTOR, CODIGO_OBRA)
);

/*==============================================================*/
/* Table: SERVIDOR                                              */
/*==============================================================*/
create table SERVIDOR
(
   CODIGO_USUARIO       int not null auto_increment,
   MATRICULA_SERVIDOR   bigint,
   primary key (CODIGO_USUARIO)
);

/*==============================================================*/
/* Table: SITUACAO_EXEMPLAR                                     */
/*==============================================================*/
create table SITUACAO_EXEMPLAR
(
   CODIGO_SITUACAO_EXEMPLAR int not null,
   DESCRICAO_SITUACAO_EXEMPLAR varchar(50) not null,
   primary key (CODIGO_SITUACAO_EXEMPLAR)
);

/*==============================================================*/
/* Table: TELEFONE_USUARIO                                      */
/*==============================================================*/
create table TELEFONE_USUARIO
(
   CODIGO_TELEFONE      int not null auto_increment,
   CODIGO_USUARIO       int not null,
   NUMERO_TELEFONE      bigint not null,
   primary key (CODIGO_TELEFONE, CODIGO_USUARIO)
);

/*==============================================================*/
/* Table: TIPO_OBRA                                             */
/*==============================================================*/
create table TIPO_OBRA
(
   CODIGO_TIPO_OBRA     int not null,
   DESCRICAO_TIPO_OBRA  varchar(50) not null,
   primary key (CODIGO_TIPO_OBRA)
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO
(
   CODIGO_USUARIO       int not null auto_increment,
   NOME_USUARIO         varchar(50) not null,
   DATA_NASCIMENTO_USUARIO date not null,
   primary key (CODIGO_USUARIO)
);

alter table ALUNO add constraint FK_INHERITANCE_2 foreign key (CODIGO_USUARIO)
      references USUARIO (CODIGO_USUARIO) on delete restrict on update restrict;

alter table DEVOLUCAO add constraint FK_DEVOLVE2 foreign key (CODIGO_USUARIO, DATA_EMPRESTIMO)
      references EMPRESTIMO (CODIGO_USUARIO, DATA_EMPRESTIMO) on delete restrict on update restrict;

alter table EMPRESTIMO add constraint FK_DEVOLVE foreign key (DATA_DEVOLUCAO)
      references DEVOLUCAO (DATA_DEVOLUCAO) on delete restrict on update restrict;

alter table EMPRESTIMO add constraint FK_EMPRESTA foreign key (CODIGO_USUARIO)
      references USUARIO (CODIGO_USUARIO) on delete restrict on update restrict;

alter table EMPRESTIMO_EXEMPLAR add constraint FK_REFERENCIA_EMPRESTIMO foreign key (CODIGO_USUARIO, DATA_EMPRESTIMO)
      references EMPRESTIMO (CODIGO_USUARIO, DATA_EMPRESTIMO) on delete restrict on update restrict;

alter table EMPRESTIMO_EXEMPLAR add constraint FK_REFERENCIA_EXEMPLAR foreign key (CODIGO_EXEMPLAR)
      references EXEMPLAR (CODIGO_EXEMPLAR) on delete restrict on update restrict;

alter table EXEMPLAR add constraint FK_PERTENCE_EXEMPLAR foreign key (CODIGO_OBRA)
      references OBRA (CODIGO_OBRA) on delete restrict on update restrict;

alter table EXEMPLAR add constraint FK_POSSUI_SITUACAO foreign key (CODIGO_SITUACAO_EXEMPLAR)
      references SITUACAO_EXEMPLAR (CODIGO_SITUACAO_EXEMPLAR) on delete restrict on update restrict;

alter table OBRA add constraint FK_POSSUI_TIPO foreign key (CODIGO_TIPO_OBRA)
      references TIPO_OBRA (CODIGO_TIPO_OBRA) on delete restrict on update restrict;

alter table OBRA_AUTOR add constraint FK_PERTENCE_AUTOR foreign key (CODIGO_OBRA)
      references OBRA (CODIGO_OBRA) on delete restrict on update restrict;

alter table OBRA_AUTOR add constraint FK_POSSUI_OBRA foreign key (CODIGO_AUTOR)
      references AUTOR (CODIGO_AUTOR) on delete restrict on update restrict;

alter table SERVIDOR add constraint FK_INHERITANCE_1 foreign key (CODIGO_USUARIO)
      references USUARIO (CODIGO_USUARIO) on delete restrict on update restrict;

alter table TELEFONE_USUARIO add constraint FK_POSSUI_TELEFONE foreign key (CODIGO_USUARIO)
      references USUARIO (CODIGO_USUARIO) on delete restrict on update restrict;

