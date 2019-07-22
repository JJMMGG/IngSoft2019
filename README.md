# IngSoft2

[Dacriper - 13/7/19] Los archivos no estan aqui. hice fork y se me subieron a mi git.. ya veo la forma de pasarlos aqui.
[Dacriper - 13/7/19] Las carpetas ya estan aqui. Faltan implementaciones y demas. Usar netbeans.
[Dacriper - 13/7/19] Agrege el UML de clases.  Allí se encuentra dos diagramas. 
                          - IngSof : estan las clases bases del proyecto
                          - abstraccion: vista general de cómo quedaría el MVC. 
[Dacriper - 17/7/19] Implementé el Login y Registro con sus vistas. Hay una clase BuySell que con un Main empieza la App.
                      Faltaria completar login y Registro perimitiendole a la App que pueda agregar un usuario.
[Dacriper - 18/7/19] Login y Registro funcionan correctamente.  
                      Faltaria avisar a los usuarios cuando se agrego un nuevo producto.
[Dacriper - 21/7/19] Avisar a los usuarios está hecho. Se agregó una opcion (actualizar) para el estado de "Nuevo Producto".
                      Falla encontrada: cuando agrego un producto el estado de "producto nuevo" pasa a SI pero cuando
                                        ejecuto otra vez BuySell se reseta la opcion "producto nuevo" a NO. El de todos los
                                        usuarios se resetea en NO.
                                        -- Ver este error en el archivo BDD_PRODUCTO.TXT
