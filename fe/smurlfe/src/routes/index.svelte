<script>
    let url = null
    let previewer = 'server says nothing now'
    let  server_response = null

    function callServer() {
        fetch("http://localhost:8080/yavuz")
        .then((response) => response.json())
        .then((responseJSON) => {
           console.log(responseJSON.original + "im here");
           console.log(responseJSON);
           server_response = "url: " + responseJSON.original + " hashed url: "+ responseJSON.hashed;
        })};

</script>

<body class="bg-[#161616] mx-12 inset-0 overflow-x-hidden overflow-y-auto">
<nav class="pt-6 flex flex-row ml-8">
<!-- logo image -->
<div class="sm:px-4">

    <h1 class="text-4xl text-[#0fda5d]"> smurl </h1>

  </div>
 <!-- /logo image -->
</nav>


<form class="rounded px-8 pt-6 pb-8 mb-4 my-auto">
    <div class="mb-4 shadow-md">
      <label class="block text-[#0fda5d] text-sm font-bold mb-2" for="username">
        paste url 
      </label>
      <input class="input shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" type="text" placeholder="smurl.com" bind:value={url}>
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
        <button on:click={callServer} type="button" class="text-[#161616] bg-[#0fda5d] border-[#0fda5d] border-dashed text-lg rounded-2xl py-1 px-6 text-bold transition ease-in-out delay-80 hover:-translate-y-1 hover:scale-100 duration-300 shadow-md hover:text-white">
            generate smurl
        </button>
        {/if}
       </div>
       

       {#if server_response != null && server_response != ''}
       <p class="text-white">
        Server responded: {server_response}
       </p>
       {/if}
    
</form>
</body>
