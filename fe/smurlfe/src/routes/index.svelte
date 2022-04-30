<script>
    let url = null
    let previewer = 'server says nothing now'
    let  server_response = null

    let isSmurl = false;

    const str1 = 'Saturday night plans';

    // Check input bar for smurl link: ----------------

    // label updates DOM on chages of url && checkIfSmurl
    $: url && checkIfSmurl() 

    function checkIfSmurl() {
    if (url.startsWith("s.mrl/") && url.length > 10) {
    isSmurl = true;
    }
    else{
        isSmurl=false;
    }
    
    }

    // ----------------------------------------
	
    function callServer() {
        fetch("http://localhost:8080/yavuz")
        .then((response) => response.json())
        .then((responseJSON) => {
           console.log(responseJSON.original + "im here");
           console.log(responseJSON);
           server_response = responseJSON.original;
        })};

        function callHash() {
        fetch("http://localhost:8080/urlhash", {
        method: 'POST',
        mode: 'cors',
        headers: {
        'Content-Type': 'application/json'
        },
        body: url
        }).then(response => response.json()).then((responseJSON) => {
        server_response = responseJSON.hashed
        }).catch(error => {
        alert('Error:', error);
        });
    };

        function enterCall() {
            return false;
        }

        function refreshCall() {
            server_response = null
            url = null
        }

    // generic fetchAPI call, obtained from MDN docs
    async function postData() {
    // Default options are marked with *
    const url_data = {  url: url   };
    fetch("http://localhost:8080/urlhash", {
    method: 'POST', // *GET, POST, PUT, DELETE, etc.
    mode: 'cors', // no-cors, *cors, same-origin
    cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
    credentials: 'same-origin', // include, *same-origin, omit
    headers: {
      'Content-Type': 'application/json'
      // 'Content-Type': 'application/x-www-form-urlencoded',
    },
    redirect: 'follow', // manual, *follow, error
    referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
    body: JSON.stringify(url_data) // body data type must match "Content-Type" header
  }).then((url_data) => url_data.json())
        .then((responseJSON) => {
           console.log(responseJSON.original + "im here");
           console.log(responseJSON);
           server_response = url_data;
        })
}



</script>

<body class="bg-[#161616] flex flex-col h-screen">
<div class="bg-[#161616] mx-12 inset-0 overflow-x-hidden overflow-y-auto flex-grow">
<nav class="pt-6 flex flex-row ml-8">
<!-- logo image -->
<div class="sm:px-4">

    <h1 class="text-4xl text-[#0fda5d]"> smurl </h1>

  </div>
 <!-- /logo image -->
</nav>


<form class="rounded px-8 pt-6 pb-8 mb-4 my-auto" onSubmit="return false;">
    <div class="mb-4 shadow-md">
      <label class="block text-[#0fda5d] text-sm font-bold mb-2" for="username">
        paste url 
      </label>
      <input class="input shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" type="text" placeholder="smurl.com" bind:value={url} onSubmit="callServer">
    </div>
    <!--
    <div class="mb-4 flex flex-row justify-center mt-4">
        <button class="text-[#161616] border-2 text-2xl rounded-xl py-1 px-6 bg-[#0fda5d] border-[#161616] text-bold">
            Generate
        </button>
       </div> 
       -->
       <div class="mb-4 flex flex-row justify-center mt-8">
        {#if url != null && url != '' && !isSmurl}
        <button on:click={callHash} type="button" class="text-[#161616] bg-[#0fda5d] border-[#0fda5d] border-dashed text-lg rounded-2xl py-1 px-6 text-bold transition ease-in-out delay-80 hover:-translate-y-1 hover:scale-100 duration-300 shadow-md hover:text-white">
            generate smurl
        </button>
        <button on:click={refreshCall} type="button" class="text-[#161616] bg-[#0fda5d] border-[#0fda5d] border-dashed text-lg rounded-2xl py-1 px-4 text-bold transition ease-in-out delay-80 hover:-translate-y-1 hover:scale-100 duration-300 shadow-md hover:text-white ml-4">
            refresh 
        </button>
        {:else}
        <script> server_response = null </script>
        {/if}

        {#if isSmurl && url != null}
        <button type="button" class="text-[#161616] bg-[#0fda5d] border-[#0fda5d] border-dashed text-lg rounded-2xl py-1 px-6 text-bold transition ease-in-out delay-80 hover:-translate-y-1 hover:scale-100 duration-300 shadow-md hover:text-white">
            de-smurl
        </button>
        {/if}
       </div>

       {#if server_response != null && server_response != '' && url != null && url != ''}
       <p class="text-white">
       <span class="text-[#0fda5d]">Original url: </span> <br> {url} <br> <span class="text-[#0fda5d]"> Your  smurl: </span> <br> {server_response}
       </p>        
       {/if}
    
</form>
</div>

<footer class="p-2 rounded-lg shadow md:flex md:items-center md:justify-between md:p-6 bg-gray-1000 static bottom-0">
    <span class="text-sm text-gray-500 sm:text-center dark:text-gray-400"> made with ❤️ by <a href="https://github.com/ya-v-uz" class="hover:underline">yavuz</a>
    </span>
    <ul class="flex flex-wrap items-center mt-3 text-sm text-gray-500 dark:text-gray-400 sm:mt-0">
        <li>
            <a href="#" class="mr-4 hover:underline md:mr-6 ">About</a>
        </li>
        <li>
            <a href="#" class="mr-4 hover:underline md:mr-6">Privacy Policy</a>
        </li>
        <li>
            <a href="#" class="mr-4 hover:underline md:mr-6">Licensing</a>
        </li>
        <li>
            <a href="#" class="hover:underline">Contact</a>
        </li>
    </ul>
</footer>
</body>