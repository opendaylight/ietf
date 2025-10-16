[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.opendaylight.ietf/ietf-artifacts/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.opendaylight.ietf/ietf-artifacts)
[![License](https://img.shields.io/badge/License-EPL%201.0-blue.svg)](https://opensource.org/licenses/EPL-1.0)

# IETF Liaison Project

## Overview

This project acts an intermediary between the [Internet Engineering Task Force](https://ietf.org) and software projects
implementing those standards, primarily under the umbrella of the [OpenDaylight Project](https://opendaylight.org).

The scope of this project is outlined in the
[project proposal](https://lf-opendaylight.atlassian.net/wiki/spaces/ODL/pages/282525740/IETF+Liaison+Project).

## Repository organization

The repository is split into the following logical parts:
* the [Bill Of Materials](artifacts)
* a library of [YANG models](model) packaged as JARs with their Java bindings
* a library of [Karaf features](features) packaging all Java artifacts hosted in this repository
* a [parent pom.xml for bundle artifacts](bnd-parent)
* a collection of model-related [libraries](lib)
* [Karaf distribution](test-distribution) packaging all features for testing purposes
