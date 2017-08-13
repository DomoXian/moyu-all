FROM maven:alpine
ADD build.sh /home/admin/
ADD . /home/admin/app/

RUN chown -R admin /home/admin/
USER admin
WORKDIR /home/admin/
