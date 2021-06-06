Cloud Computing Theory
==

# A. What is the difference between container based virtualization and hypervisor based virtualization?

In a nutshell, hypervisors abstract away hardware and enable you to run operating systems; whereas containers (technically container engines) abstract away operating systems and enable you to run applications.

There're 2 types of hypervisors:
* type 1 is a lightweight operating system(hypervisor) is installed on a physical computer or server (bare-metal). Examples: KVM, ECXi
* type 2 a.k.a "hosted hypervisors", installed on top of a standard operating system. Examples: VirtualBox, VMWare Player

A simplified comparison of container (left) vs type 2 hypervisor (right)

![image](./Container-based-virtualization-vs-hypervisor-based-virtualization.png)


# B. Explain the idea of ​Immutable Servers​ and discuss the pros and cons.

In a nutshell, from [Martin Fowler](https://martinfowler.com/bliki/ImmutableServer.html)

> Automated configuration tools (such as CFEngine, Puppet, or Chef) allow you to specify how servers should be configured, and bring new and existing machines into compliance. This helps to avoid the problem of fragile SnowflakeServers. Such tools can create PhoenixServers that can be torn down and rebuilt at will. An Immutable Server is the logical conclusion of this approach, a server that once deployed, is never modified, merely replaced with a new updated instance.

Pros
* Reduction in configuration drifts.
* Simplified deployments. No need to support upgrade as upgrade are just new deployments and they're easier to automate.
* Atomic deployments. Deployments either complete successfully or nothing changes, no in-between states.
* Safer deployments with fast rollback and recovery processes
* Consistent, repeatable and portable environment, easy to testing and debugging
* Simplified toolchain. No need for configuration management tools or agents on servers. Changes are made to the base image and version controlled.
* Increased security. We can disable SSH and remove Shell access to servers.

Cons
* Higher initial overhead to learn new tooling and implement the infrastructure and deployment pipeline
* Even quick fixes require a full redeploy.
* Possible increase in resource usage and cost depending on how often servers are destroyed and redeployed
* Need to externalize data storage for persisting as local storage are volatile.

However, in the long term as complexity grow the pros of immutable servers far outweighs its cons which why it's the dominant approach today.

# C. In Amazon Web Services, explain the difference between a​ Region​, ​Availability Zone and ​Instance​ in relation to fault domains.

A fault domain is a collection of functionality, services or components with a shared single point of failure. A fault level is a set of one or more fault domains serving the same purpose.

Each Amazon Region is designed to be isolated from the other Amazon Regions. Each Region has multiple, isolated locations known as Availability Zones. An instance belongs to one of the AZ. So region provides highest fault level, followed by availability zone level and instance level. To use an example, suppose we have a TikTok like service running on a single EC2 instance
* If the server dies, then our service dies
* To improve resiliency, we can spin up serveral instances accross different availability zones so that if one instance dies or one whole AZ dies, our services are still accessible (although might be degraded)
* To further improve resiliency, we can run replicate above to multiple regions so in the event of a entire region is down (e.g. hit by asteroid), our services will still be normal


