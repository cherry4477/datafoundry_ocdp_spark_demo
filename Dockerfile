FROM registry.dataos.io/ocdp/spark-client

ADD jars /root/jars

RUN chmod +x /root/jars

COPY scripts/start.sh /root/

RUN chmod +x /root/start.sh

WORKDIR /root

ENTRYPOINT ["/bin/bash", "-c", "sh ./start.sh"]

