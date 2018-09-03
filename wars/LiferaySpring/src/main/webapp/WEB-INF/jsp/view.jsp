<%@ include file="init.jsp"%>

<style>
.portlet-title-text {
	display: none;
}
</style>
<link
	href="/o/photoapp-theme/css/plugins/blueimp/css/blueimp-gallery.min.css"
	rel="stylesheet" />
<link href="/o/photoapp-theme/css/animate.css" rel="stylesheet" />
<portlet:resourceURL var="thumbnailResourceUrl">
	<portlet:param name="render" value="get-thumbnail" />
</portlet:resourceURL>
<portlet:resourceURL var="imageResourceUrl">
	<portlet:param name="render" value="get-image" />
</portlet:resourceURL>


<div class="wrapper wrapper-content">
	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">

				<div class="ibox-content">

					<h2>Lightbox image gallery</h2>
					<p>
						<strong>NeoConnect Gallery</strong> is a touch-enabled, responsive
						and customizable image & video gallery, carousel and lightbox,
						optimized for both mobile and desktop web browsers. It features
						swipe, mouse and keyboard navigation, transition effects,
						slideshow functionality, fullscreen support and on-demand content
						loading and can be extended to display additional content types.
						Full documentation you can find at: <a
							href="https://github.com/neoconnect/Gallery/blob/master/README.md"
							target="_blank">https://github.com/neoconnect/Gallery/blob/master/README.md</a>
					</p>

					<div class="lightBoxGallery">
						<c:choose>
							<c:when test="${not isUserExists}">
								<h1>
									<b>Oops you have to log in to view your uploaded
										picture.!!!</b>
								</h1>

							</c:when>
							<c:otherwise>
								<div class="links" id="links">
									<c:choose>
										<c:when test="${fn:length(photIds) gt 0}">
											<c:forEach var="id" items="${photIds}">
												<a href="${imageResourceUrl}&imageid=${id}"
													title="Image from Unsplash" data-gallery=""> <img
													src="${thumbnailResourceUrl}&imageid=${id}">
												</a>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<h1><b> There is no Picture uploaded by you.!!! </b></h1>
										</c:otherwise>
									</c:choose>
								</div>

							</c:otherwise>
						</c:choose>

						<!-- The Gallery as lightbox dialog, should be a child element of the document body -->
						<div id="blueimp-gallery"
							class="blueimp-gallery blueimp-gallery-controls">
							<div class="slides"></div>
							<h3 class="title"></h3>
							<a class="prev">&#171;</a> <a class="next">&#187;</a> <a
								class="close">X</a> <a class="play-pause"></a>
							<ol class="indicator"></ol>
						</div>

					</div>

				</div>
			</div>
		</div>

	</div>
</div>
<!-- blueimp gallery -->
<script>
	window.__define = window.define;
	window.__require = window.require;
	window.define = undefined;
	window.require = undefined;
</script>

<script
	src="/o/photoapp-theme/js/plugins/blueimp/jquery.blueimp-gallery.min.js"></script>

<script>
	window.define = window.__define;
	window.require = window.__require;
	window.__define = undefined;
	window.__require = undefined;
</script>

<script>
	try {
		document.getElementById('links').onclick = function(event) {
			event = event || window.event;
			var target = event.target || event.srcElement, link = target.src ? target.parentNode
					: target, options = {
				index : link,
				event : event
			}, links = this.getElementsByTagName('a');
			blueimp.Gallery(links, options);
		};
	} catch (ex) {
		console.log("gallery ex: " + ex);
	}
</script>





