<script>
    let url = null
    let previewer = 'server says nothing now'
    let  server_response = 'no server response'

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
        // 'Content-Type': 'application/x-www-form-urlencoded',
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
  
  //return response.json(); // parses JSON response into native JavaScript objects
}



</script>

<body class="bg-[#161616] mx-12 inset-0 overflow-x-hidden overflow-y-auto">
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
        {#if url != null && url != ''}
        <button on:click={callHash} type="button" class="text-[#161616] bg-[#0fda5d] border-[#0fda5d] border-dashed text-lg rounded-2xl py-1 px-6 text-bold transition ease-in-out delay-80 hover:-translate-y-1 hover:scale-100 duration-300 shadow-md hover:text-white">
            generate smurl
        </button>
        <button on:click={refreshCall} type="button" class="text-[#161616] bg-[#0fda5d] border-[#0fda5d] border-dashed text-lg rounded-2xl py-1 px-4 text-bold transition ease-in-out delay-80 hover:-translate-y-1 hover:scale-100 duration-300 shadow-md hover:text-white ml-4">
            refresh
        </button>
        {:else}
        <script> server_response = null </script>
        {/if}
       </div>
       
       {#if server_response != null && server_response != '' && url != null && url != ''}
       <p class="text-white">
       <span class="text-[#0fda5d]">Original url: </span> <br> {url} <br> <span class="text-[#0fda5d]"> Your  smurl: </span> <br> {server_response}
       </p>        
       {/if}
    
</form>
</body>
