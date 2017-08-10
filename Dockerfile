FROM daocloud.io/centos:7
ADD start.sh /home/admin/
ADD . /home/admin/app/src/app/
RUN chown -R admin:admin /home/admin/
USER admin
WORKDIR /home/admin
