#!/bin/bash
echo "INICIANDO BUILD DO ADMIN"
#pull e build do mpr-admin
git pull && mvn clean install

path=target/admin.war

if [ -f "$path" ]; then
    echo "Removendo os containers e as imagens anteriores"
    docker rm -f fe && docker rmi mpr/admin 
    docker rm -f nginx && docker rmi mpr/nginx
    echo "Iniciando o compose"
    docker-compose up -d
    echo "FIM DO BUILD"

else
    echo "ERROR: Algum erro no build não gerou o war. Implementar envio de email"
fi