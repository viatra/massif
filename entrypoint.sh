#!/bin/sh -l

echo "Outputting the most useful and important thing: $1"
shametag=$(date)
echo "::set-output name=shametag::$shametag"
