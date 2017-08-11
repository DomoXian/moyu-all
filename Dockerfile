FROM maven:alpine
ADD start.sh /home/admin/
ADD . /home/admin/app/src/app/

# RUN chown -R admin:admin /home/admin/
# USER admin
# WORKDIR /home/admin/
