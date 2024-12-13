FROM alpine:3.17

RUN apk update && \
    apk -q add wget jq postgresql-client bash curl procps

COPY ./bootstrap ./opt

WORKDIR /opt

RUN addgroup -g 10001 -S nonroot \
  && adduser -H -G nonroot -S -u 10001 nonroot
RUN chown -R nonroot:nonroot /opt/

USER 10001:10001

CMD ["/bin/bash", "-c", "/opt/bootstrap.sh"]

