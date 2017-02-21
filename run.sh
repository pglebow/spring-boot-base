#!/bin/sh
for i in {1..100}
do
	curl https://external.apps.cfdev.phx.gaptech.com/external
	sleep 5
done
