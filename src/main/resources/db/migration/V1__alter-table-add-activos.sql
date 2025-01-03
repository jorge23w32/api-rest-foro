alter table perfiles add activo boolean;
update perfiles set perfiles.activo = true;

alter table usuarios add activo boolean;
update usuarios set usuarios.activo = true;

alter table cursos add activo boolean;
update cursos set cursos.activo = true;

alter table topicos add activo boolean;
update topicos set topicos.activo = true;

alter table respuestas add activo boolean;
update respuestas set respuestas.activo = true;