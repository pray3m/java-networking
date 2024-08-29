[contributors-shield]: https://img.shields.io/github/contributors/pray3m/java-networking.svg?style=for-the-badge
[contributors-url]: https://github.com/pray3m/java-networking/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/pray3m/java-networking.svg?style=for-the-badge
[forks-url]: https://github.com/pray3m/java-networking/network/members
[stars-shield]: https://img.shields.io/github/stars/pray3m/java-networking.svg?style=for-the-badge
[stars-url]: https://github.com/pray3m/java-networking/stargazers
[issues-shield]: https://img.shields.io/github/issues/pray3m/java-networking.svg?style=for-the-badge
[issues-url]: https://github.com/pray3m/java-networking/issues
[license-shield]: https://img.shields.io/github/license/pray3m/java-networking.svg?style=for-the-badge
[license-url]: https://github.com/pray3m/java-networking/blob/main/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555

_Work in Progress_

<div align="center">
<h1> Network Programming : Comprehensive Guide <br>| with Java |</h1>

<p align="center"><strong>

Documentation, Examples and Resources

</strong></p>

<!-- [![Stargazers][stars-shield]][stars-url] [![Forks][forks-shield]][forks-url]
[![Contributors][contributors-shield]][contributors-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url] -->

<!-- Badges -->
<div>
<a href="https://github.com/pray3m/java-networking/stargazers">
  <img src="https://img.shields.io/github/stars/pray3m/java-networking.svg?style=for-the-badge" alt="Stargazers" />
</a>
<a href="https://github.com/pray3m/java-networking/network/members">
  <img src="https://img.shields.io/github/forks/pray3m/java-networking.svg?style=for-the-badge" alt="Forks" />
</a>
<a href="https://github.com/pray3m/java-networking/graphs/contributors">
  <img src="https://img.shields.io/github/contributors/pray3m/java-networking.svg?style=for-the-badge" alt="Contributors" />
</a>
<a href="https://github.com/pray3m/java-networking/issues">
  <img src="https://img.shields.io/github/issues/pray3m/java-networking.svg?style=for-the-badge" alt="Issues" />
</a>
<a href="https://github.com/pray3m/java-networking/blob/main/LICENSE.txt">
  <img src="https://img.shields.io/github/license/pray3m/java-networking.svg?style=for-the-badge" alt="MIT License" />
</a>
</div>

<br> 
<h4> Welcome to the repository for Networking Programming <br>| with Java |<br>| BCA , CSIT , BIT | <br></h4>

 <a href="https://github.com/pray3m/java-networking/" title="Star this repository">
    <img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white" alt="Star" />
  </a>
<br> 
</div>

# Table of Contents

## [01-InternetAddress](./01-InternetAddress/README.md)
  - [IP (Internet Protocol) Address](./01-InternetAddress/README.md#ip-internet-protocol-address)
  - [Domain Names](./01-InternetAddress/README.md#domain-names)
  - [The InetAddress Class](./01-InternetAddress/README.md#the-inetaddress-class)
    - [Creating new InetAddress objects](./01-InternetAddress/README.md#creating-new-inetaddress-objects)
    - [Static Methods](./01-InternetAddress/README.md#static-methods)
    - [Getter Methods](./01-InternetAddress/README.md#getter-methods)
    - [Address Types](./01-InternetAddress/README.md#address-types)
    - [Testing Reachability](./01-InternetAddress/README.md#testing-reachability)
    - [Object Methods](./01-InternetAddress/README.md#object-methods)
  - [Inet4Address and Inet6Address](./01-InternetAddress/README.md#inet4address-and-inet6address)
- [Network Interface](./01-InternetAddress/README.md#network-interface)
  - [The NetworkInterface Class](./01-InternetAddress/README.md#the-networkinterface-class)
    - [Creating New NetworkInterface Objects](./01-InternetAddress/README.md#creating-new-networkinterface-objects)
    - [Static Factory Methods](./01-InternetAddress/README.md#static-factory-methods)
    - [Getter Methods](./01-InternetAddress/README.md#getter-methods)

## [02-URLs](./02-URLs/README.md)
  - [The Real Difference: URIs vs URLs vs URNs](./02-URLs/README.md#the-real-difference-uris-vs-urls-vs-urns)
  - [Structure of a URL](./02-URLs/README.md#structure-of-a-url)
  - [The URL Class](./02-URLs/README.md#the-url-class)
    - [Creating new URL objects](./02-URLs/README.md#creating-new-url-objects)
    - [Retrieving Data from a URL](./02-URLs/README.md#retrieving-data-from-a-url)
      - [InputStream openStream()](./02-URLs/README.md#inputstream-openstream)
      - [URLConnection openConnection()](./02-URLs/README.md#urlconnection-openconnection)
      - [URL Connection openConnection(Proxy proxy)](./02-URLs/README.md#url-connection-openconnectionproxy-proxy)
      - [Object getContent()](./02-URLs/README.md#object-getcontent)
    - [Getter Methods](./02-URLs/README.md#getter-methods)
  - [The URI Class](./02-URLs/README.md#the-uri-class)
    - [Creating new URI objects](./02-URLs/README.md#creating-new-uri-objects)
    - [Getter Methods](./02-URLs/README.md#getter-methods-1)
    - [Resolving Relative URIs](./02-URLs/README.md#resolving-relative-uris)
  - [The URLEncoder and URLDecoder Classes](./02-URLs/README.md#the-urLEncoder-and-urldecoder-classes)
    - [URLEncoder](./02-URLs/README.md#urlencoder)
    - [URLDecoder](./02-URLs/README.md#urldecoder)
  - [Proxies](./02-URLs/README.md#proxies)
    - [System Properties](./02-URLs/README.md#system-properties)
    - [The Proxy Class](./02-URLs/README.md#the-proxy-class)
    - [The ProxySelector Class](./02-URLs/README.md#the-proxyselector-class)
  - [Communicating with server side programs through GET](./02-URLs/README.md#communicating-with-server-side-programs-through-get)
  - [Accessing Password Protected Sites](./02-URLs/README.md#accessing-password-protected-sites)
    - [The Authenticator Class](./02-URLs/README.md#the-authenticator-class)
    - [The Password Authentication Class](./02-URLs/README.md#the-password-authentication-class)
    - [JPassword Field Class](./02-URLs/README.md#jpassword-field-class)

## [03-HTTP](./03-HTTP/README.md)
  - [The HTTP Protocol](./03-HTTP/README.md#the-http-protocol)
    - [Typical Client Request](./03-HTTP/README.md#typical-client-request)
    - [Typical Server Response](./03-HTTP/README.md#typical-server-response)
  - [HTTP Methods](./03-HTTP/README.md#http-methods)
    - [GET](./03-HTTP/README.md#get)
    - [POST](./03-HTTP/README.md#post)
    - [PUT](./03-HTTP/README.md#put)
    - [DELETE](./03-HTTP/README.md#delete)
    - [HEAD](./03-HTTP/README.md#head)
    - [PATCH](./03-HTTP/README.md#patch)
    - [OPTIONS](./03-HTTP/README.md#options)
    - [CONNECT](./03-HTTP/README.md#connect)
  - [Status Codes](./03-HTTP/README.md#status-codes)
  - [HTTP Cookies](./03-HTTP/README.md#http-cookies)
    - [Cookie Structure](./03-HTTP/README.md#cookie-structure)
    - [Cookie Handler](./03-HTTP/README.md#cookie-handler)
    - [Default Cookie Manager](./03-HTTP/README.md#default-cookie-manager)
    - [Custom Cookie Manager](./03-HTTP/README.md#custom-cookie-manager)
    - [Cookie Store](./03-HTTP/README.md#cookie-store)
    - [HttpCookie](./03-HTTP/README.md#httpcookie)
  - [Program](./03-HTTP/README.md#program)

<p align="right">(<a href="#table-of-contents">back to top</a>) ⬆️</p>


## [04-URLConnections](./04-URLConnections/README.md)
  - [URL Connections](./04-URLConnections/README.md#url-connections)
    - [Methods of URLConnection class](./04-URLConnections/README.md#methods-of-urlconnection-class)
    - [Reading the Header](./04-URLConnections/README.md#reading-the-header)
      - [i. Retrieving specific header fields](./04-URLConnections/README.md#i-retrieving-specific-header-fields)
      - [ii. Retrieving arbitrary header fields](./04-URLConnections/README.md#ii-retrieving-arbitrary-header-fields)
    - [Caches](./04-URLConnections/README.md#caches)
    - [HttpURLConnection](./04-URLConnections/README.md#httpurlconnection)
    - [The URLStreamHandler Class](./04-URLConnections/README.md#the-urlstreamhandler-class)

## [05-Socket](./05-Socket/README.md)
  - [Sockets in Java: Client-Side](./05-Socket/README.md#sockets-in-java-client-side)
    - [Socket Class](./05-Socket/README.md#socket-class)
    - [Constructors](./05-Socket/README.md#constructors)
      - [Basic Constructors](./05-Socket/README.md#basic-constructors)
      - [Proxy Constructors](./05-Socket/README.md#proxy-constructors)
      - [Constructing without Connecting](./05-Socket/README.md#constructing-without-connecting)
    - [Getting Socket Information](./05-Socket/README.md#getting-socket-information)
    - [Sending and Receiving Data](./05-Socket/README.md#sending-and-receiving-data)
      - [Creating a Client Socket](./05-Socket/README.md#creating-a-client-socket)
      - [Common Operations](./05-Socket/README.md#common-operations)
      - [Example: Simple Client](./05-Socket/README.md#example-simple-client)
    - [Socket Options](./05-Socket/README.md#socket-options)
      - [TCP_NODELAY](./05-Socket/README.md#tcp_nodelay)
      - [SO_TIMEOUT](./05-Socket/README.md#so_timeout)
      - [SO_LINGER](./05-Socket/README.md#so_linger)
      - [SO_KEEPALIVE](./05-Socket/README.md#so_keepalive)
      - [SO_REUSEADDR](./05-Socket/README.md#so_reuseaddr)
      - [SO_RCVBUF](./05-Socket/README.md#so_rcvbuf)
      - [SO_SNDBUF](./05-Socket/README.md#so_sndbuf)
      - [SO_OOBINLINE](./05-Socket/README.md#so_oobinline)
      - [IP_TOS](./05-Socket/README.md#ip_tos)

## [10-IPMulticast](./10-IPMulticast/README.md)
  - [Multicast Addresses and Groups](./10-IPMulticast/README.md#multicast-addresses-and-groups)
    - [Multicast Groups](./10-IPMulticast/README.md#multicast-groups)
  - [Examples of Multicast Groups in Use](./10-IPMulticast/README.md#examples-of-multicast-groups-in-use)
  - [Multicast Addresses](./10-IPMulticast/README.md#multicast-addresses)
    - [IPv4 Multicast Addresses](./10-IPMulticast/README.md#ipv4-multicast-addresses)
  - [Clients and Servers](./10-IPMulticast/README.md#clients-and-servers)
  - [Routers and Routing](./10-IPMulticast/README.md#routers-and-routing)
  - [Working with Multicast Sockets](./10-IPMulticast/README.md#working-with-multicast-sockets)
    - [Constructors](./10-IPMulticast/README.md#constructors)
  - [Communication With A Multicast Group](./10-IPMulticast/README.md#communication-with-a-multicast-group)
    - [Joining a Multicast Group](./10-IPMulticast/README.md#joining-a-multicast-group)
    - [Sending Data to a Multicast Group](./10-IPMulticast/README.md#sending-data-to-a-multicast-group)

## [11-RMI](./11-RMI/README.md)
  - [Introduction](./11-RMI/README.md#introduction)
    - [Stubs and Skeletons](./11-RMI/README.md#stubs-and-skeletons)
    - [RMI Registry](./11-RMI/README.md#rmi-registry)
  - [Implementation Steps](./11-RMI/README.md#implementation-steps)
    - [1. Define the Remote Interface](./11-RMI/README.md#define-the-remote-interface)
    - [2. Marshalling and Unmarshalling](./11-RMI/README.md#marshalling-and-unmarshalling)
    - [3. Implement the Remote Interface](./11-RMI/README.md#implement-the-remote-interface)
      - [Steps to Implement the Remote Interface](./11-RMI/README.md#steps-to-implement-the-remote-interface)
    - [4. Implement the Server](./11-RMI/README.md#implement-the-server)
    - [5. Create the Client](./11-RMI/README.md#create-the-client)
  - [Compilation & Execution](./11-RMI/README.md#compilation--execution)
    - [Execution Steps](./11-RMI/README.md#execution-steps)
      - [Compile all the Java files](./11-RMI/README.md#compile-all-the-java-files)
      - [Generate the Stub files](./11-RMI/README.md#generate-the-stub-files)
      - [Start the RMI Registry](./11-RMI/README.md#start-the-rmi-registry)
      - [Start the Server](./11-RMI/README.md#start-the-server)
      - [Run the Client](./11-RMI/README.md#run-the-client)

<summary>
<a href="#congratulations">Congratulations</a>
</summary>


<a href="#thank-you">Thank you </a>

<p align="right">(<a href="#table-of-contents">back to top</a>) ⬆️</p>

# Congratulations

🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊 Completed all The Course! 🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊🎊

<!-- ## Where do I go now? -->

<!-- ### Learning More -->

<!-- - [Top 10 learning resources](https://patrickalphac.medium.com/top-10-smart-contract-solidity-developer-learning-resources-cb9d60dd1146)
- [Patrick Collins](https://www.youtube.com/channel/UCn-3f8tw_E1jZvhuHatROwA)
- [CryptoZombies](https://cryptozombies.io/)
- [Alchemy University](https://www.alchemy.com/dapps/alchemy-university)
- [Speed Run Ethereum](https://speedrunethereum.com/)
- [Ethereum.org](https://ethereum.org/en/) -->
  


# Thank you <3 !

Thanks to everyone who is taking, participating in, and working on this repo !. 

<a href="https://github.com/pray3m/java-networking/graphs/contributors">

💚 Contributors
<!-- <img src="https://contrib.rocks/image?repo=pray3m/java-networking" /> -->

</a>

## License

Java Networking content is open-sourced [licensed as GPLv3](https://github.com/pray3m/java-networking/blob/main/LICENSE).

## ⭐ Star the Repository

If you find this repository useful, please give it a star! It helps others find the project and shows your support.

[Star the Repository](https://github.com/pray3m/java-networking)

## 🤝 Contribute

We welcome contributions to this repository. If you want to contribute, please follow these steps:

1. Fork the repository
2. Create a new branch (`git checkout -b feature/YourFeature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/YourFeature`)
5. Create a new Pull Request

Your contributions will help improve this project for everyone!


<p align="right">(<a href="#table-of-contents">back to top</a>) ⬆️</p>